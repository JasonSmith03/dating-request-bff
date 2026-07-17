package com.example.date_planner_bff.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Activity {

    WATCH_A_GAME("Watch a Game"),
    RUN_DRINK("Run & Drinks"),
    COMEDY("Comedy"),
    MINI_GOLF("Mini Golf"),
    ARCADE("Arcade"),
    BOWLING("Bowling"),
    PICNIC("Picnic"),
    PAINT_NIGHT("Paint Night");

    private final String displayName;

    Activity(String displayName) {
        this.displayName = displayName;
    }


    @JsonCreator
    public static Activity fromValue(String value) {

        return Arrays.stream(values())
                .filter(activity ->
                        activity.displayName.equalsIgnoreCase(value)
                )
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Invalid activity: " + value
                        )
                );
    }


    @JsonValue
    public String getDisplayName() {
        return displayName;
    }
}