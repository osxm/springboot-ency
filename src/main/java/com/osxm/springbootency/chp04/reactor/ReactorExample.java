/**
 * Description:
 * Author: XM
 * Date: 2024-07-20
 */

package com.osxm.springbootency.chp04.reactor;

import reactor.core.publisher.Flux;

public class ReactorExample {
    public static void main(String[] args) {
        // 创建一个Flux，它生成一个包含1到5的整数序列
        Flux<Integer> numbers = Flux.range(1, 5);
        // 对Flux中的每个元素进行平方操作
        Flux<Integer> squaredNumbers = numbers.map(n -> n * n);
        // 订阅Flux，并打印结果
        squaredNumbers.subscribe(
                // 消费元素
                number -> System.out.println(number),
                // 处理错误（这里我们简单打印错误信息）
                error -> System.err.println("Error: " + error),
                // 完成时执行的操作
                () -> System.out.println("Completed"));
    }
}
