package com.example.testserver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.Duration

@RestController
class TestController {

    val trackingResponse = ClassLoader.getSystemClassLoader().getResource("tracking.json")!!.readText()

    @GetMapping("/tracking")
    fun testMethod(): Mono<String> {
        return Mono.just(trackingResponse)
            .delayElement(Duration.ofMillis(2000))
    }
}