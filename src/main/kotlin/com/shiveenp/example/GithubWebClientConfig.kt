package com.shiveenp.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class GithubWebClientConfig {

    @Bean
    fun webClient(clientRegistrations: ReactiveClientRegistrationRepository?,
                  authorizedClients: ServerOAuth2AuthorizedClientRepository?): WebClient? {
        val oauth = ServerOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrations, authorizedClients)
         oauth.setDefaultOAuth2AuthorizedClient(true)
        return WebClient.builder()
            .filter(oauth)
            .build()
    }
}
