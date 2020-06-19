package com.shiveenp.example

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.bodyValueAndAwait


@Component
class Handler(val service: Service) {

    suspend fun getStarredReposAsFlow(req: ServerRequest): ServerResponse {
        val starredRepos = service.getUserStarredReposAsFlow()
        return ok().bodyAndAwait(starredRepos)
    }

    suspend fun getStarredReposAsList(req: ServerRequest): ServerResponse {
        val starredRepos = service.getUserStarredReposAsList()
        return ok().bodyValueAndAwait(starredRepos)
    }
}
