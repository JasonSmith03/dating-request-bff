package com.example.date_planner_bff.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SupabaseConfig {


    @Bean
    WebClient supabaseClient(
            @Value("${supabase.url}") String url,
            @Value("${supabase.service-key}") String key
    ){

        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(
                        "apikey",
                        key
                )
                .defaultHeader(
                        "Authorization",
                        "Bearer " + key
                )
                .build();

    }

}