package com.shiveenp.example

import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.coRouter

@RestController
class Router {

    @Bean
    fun routes(handler: Handler) = coRouter {
        "/".nest {
            GET("", handler::hello)
        }
    }
}
