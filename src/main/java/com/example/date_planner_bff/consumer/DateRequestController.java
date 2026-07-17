package com.example.date_planner_bff.consumer;


import com.example.date_planner_bff.model.DateRequestDto;
import com.example.date_planner_bff.operation.DateRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DateRequestController {


    private final DateRequestService service;


    public DateRequestController(DateRequestService service) {
        this.service = service;
    }


    @PostMapping("/date-request")
    public ResponseEntity<?> create(
            @Valid @RequestBody DateRequestDto request
    ){

        service.save(request);

        return ResponseEntity.ok(
                Map.of(
                        "message",
                        "Date request submitted"
                )
        );
    }
}