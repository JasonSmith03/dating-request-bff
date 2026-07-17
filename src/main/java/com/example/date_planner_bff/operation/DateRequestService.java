package com.example.date_planner_bff.operation;

import com.example.date_planner_bff.model.DateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class DateRequestService {


    private final WebClient supabaseClient;
    public DateRequestService(WebClient supabaseClient) {
        this.supabaseClient = supabaseClient;
    }

    public void save(DateRequestDto request){


        Map<String,Object> body =
                Map.of(
                        "name", request.name(),
                        "activity", request.activity(),
                        "date", request.date(),
                        "time", request.time()
                );

        supabaseClient.get()
                .uri("/auth/v1/user")
                .retrieve()
                .bodyToMono(Void.class);

        supabaseClient.post()
                .uri("/rest/v1/date_requests")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

    }

}