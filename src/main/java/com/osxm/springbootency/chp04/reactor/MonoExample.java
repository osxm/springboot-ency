
/**
 * Description:
 * Author: XM
 * Date: 2024-07-20
 */
package com.osxm.springbootency.chp04.reactor;

import reactor.core.publisher.Mono;  
  
public class MonoExample {  
  
    public static void main(String[] args) {  
        // 创建一个简单的Mono  
        Mono<String> mono = Mono.just("Hello, Reactor!");  
  
        // 订阅并处理结果  
        mono.subscribe(  
            // 成功时调用  
            result -> System.out.println(result),  
            // 错误时调用  
            error -> System.err.println("An error occurred: " + error),  
            // 完成时调用  
            () -> System.out.println("Completed!")  
        );  
    }  
}