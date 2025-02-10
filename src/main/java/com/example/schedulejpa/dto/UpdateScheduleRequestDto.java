package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {

    private final String contents;

    public UpdateScheduleRequestDto(String contents) {
        this.contents = contents;
    }
}
