package com.example.schedulejpa.dto;

import com.example.schedulejpa.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleResponseDto(Long id, String userName, String title, String contents, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ScheduleResponseDto toDto (Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getUserName(), schedule.getTitle(), schedule.getContents(), schedule.getCreatedAt(), schedule.getUpdatedAt());
    }
}
