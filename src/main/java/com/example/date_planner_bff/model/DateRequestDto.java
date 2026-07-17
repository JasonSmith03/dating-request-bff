package com.example.date_planner_bff.model;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

public record DateRequestDto(

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        @Pattern(
                regexp = "^[a-zA-Z ]+$",
                message = "Name can only contain letters and spaces"
        )
        String name,


        @NotBlank(message = "Activity is required")
        Activity activity,


        @NotNull(message = "Date is required")
        LocalDate date,


        @NotNull(message = "Time is required")
        LocalTime time

) {}