package com.hack.backend;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class FastApiClient {
    private final WebClient webClient;

    public FastApiClient(WebClient webClient) {
        this.webClient = WebClient
                .builder()
                .baseUrl("http://127.0.0.1:8000")
                .build();
    }

    public void callFastApi() {

        Mono<String> response = webClient.get()
                // "/" 엔드포인트 호출
                .uri("/")
                .retrieve()
                .bodyToMono(String.class);

        response.subscribe(body -> System.out.println("Response from /: " + body));

        // "/items/{item_id}" 엔드포인트 호출
        Mono<String> itemResponse = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/items/{item_id}")
                        .queryParam("q", "test")
                        .build(1))
                .retrieve()
                .bodyToMono(String.class);

        itemResponse.subscribe(body -> System.out.println("Response from /items/{}: " + body));
    }
}
