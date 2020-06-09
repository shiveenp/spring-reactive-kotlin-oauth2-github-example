package com.shiveenp.example

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlow

@Service
class Service(val client: WebClient) {

    suspend fun getUserStarredRepos(): Flow<String> {
        return client
            .get()
            .uri("https://api.github.com/user/starred?page=1")
            .retrieve()
            .bodyToFlow()
    }
}
