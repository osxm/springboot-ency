
/**
 * Description:
 * Author: XM
 * Date: 2024-07-21
 */

package com.osxm.springbootency.chp04.webflux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class StreamController {

    @GetMapping(value = "/stream-data", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamData() {
        // 创建一个Flux，它每秒生成一个包含当前时间戳的字符串，并持续10秒
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "Data: " + System.currentTimeMillis() + "\n\n") // SSE要求每条消息后有两个换行符
                .take(10); // 限制为10条消息
    }

    @GetMapping(value = "/stream-data-sync", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> streamDataSync() throws Exception {
        return Mono.just("Start")
                .flatMap(s -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } // 注意：在生产环境中，避免在Mono的Callable中直接阻塞
                    return Mono.just("Step 1 Completed");
                })
                .flatMap(result1 -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } // 同上
                    return Mono.just("Step 2 Completed based on " + result1); // 实际上这里result1可能不会被用到，除非有额外的逻辑
                })
                // 可以继续添加更多的flatMap来执行更多步骤
                .map(result -> "data: " + result + "\n\n"); // 格式化SSE消息

    }

    @GetMapping(value = "/stream-data2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamData2() {
        // 使用AtomicInteger来确保线程安全地更新计数器
        AtomicInteger iCount = new AtomicInteger(1);

        // 创建一个Flux，其中包含按顺序执行的任务
        return Flux.concat(
                // 第一个任务
                Mono.fromCallable(() -> {
                    int currentCount = iCount.addAndGet(10); // 安全地增加计数器
                    try {
                        Thread.sleep(2000); // 模拟耗时操作
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return "Interrupted";
                    }
                    return "Result of Task 1," + currentCount;
                })
                        .subscribeOn(Schedulers.boundedElastic()), // 使用弹性线程池来避免阻塞主线程

                // 第二个任务
                Mono.fromCallable(() -> {
                    int currentCount = iCount.addAndGet(10); // 再次安全地增加计数器
                    try {
                        Thread.sleep(2000); // 模拟耗时操作
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return "Interrupted";
                    }
                    return "Result of Task 2," + currentCount;
                })
                        .subscribeOn(Schedulers.boundedElastic()));
        // 注意：上面的代码实际上可以简化，因为第二个任务不需要显式地依赖于第一个任务的结果
        // 如果它们真的是独立的，你可以直接创建第二个Mono，而不是在flatMap中创建

        // 但是，为了展示如何按顺序获取结果并将它们放入Flux中，我们可以这样做：
        // return Flux.concat(
        //         firstTask.map(Flux::just), // 将Mono转换为只包含一个元素的Flux
        //         secondTask.map(Flux::just) // 同样，将第二个Mono也转换为Flux
        // )
        //         .flatMap(Flux::from); // 将Flux<Flux<String>>展平为Flux<String>

    }
}
