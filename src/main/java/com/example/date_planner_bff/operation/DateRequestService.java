package com.example.date_planner_bff.operation;

import com.example.date_planner_bff.model.DateRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@Slf4j
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

        supabaseClient.post()
                .uri("/rest/v1/date_requests")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
        log.info("Date request saved successfully: name: {}", request.name());
    }
}