package com.raza.sb3client.config;

import com.raza.sb3client.service.StudentClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient studentServiceWebClient(){
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Bean
    public StudentClientService studentClientService(){
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory
                        .builder()
                        .clientAdapter(WebClientAdapter.create(studentServiceWebClient()))
                        .build();
        return httpServiceProxyFactory.createClient(StudentClientService.class);
    }
}
