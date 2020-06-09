package com.shiveenp.example

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait


@Component
class Handler(val service: Service) {

    suspend fun hello(req: ServerRequest): ServerResponse {

        return ok().bodyAndAwait(service.getUserStarredRepos())
    }
}
