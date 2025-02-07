package com.example.schedulejpa.dto;

import com.example.schedulejpa.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String userName;
    private final String title;
    private final String contents;

    public ScheduleResponseDto(Long id, String userName, String title, String contents) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }

    public static ScheduleResponseDto toDto (Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getUserName(), schedule.getTitle(), schedule.getContents());
    }
}
