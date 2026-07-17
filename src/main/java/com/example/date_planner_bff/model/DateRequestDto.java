package com.example.date_planner_bff.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DateRequestDto(

        @NotBlank
        @Size(max = 50)
        String name,

        @NotBlank
        String activity,

        @NotBlank
        String date,

        @NotBlank
        String time

) {}