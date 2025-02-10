package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.ScheduleResponseDto;
import com.example.schedulejpa.entity.Schedule;
import com.example.schedulejpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save (String userName, String title, String contents) {
        Schedule schedule = new Schedule(userName, title, contents);
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule.getId(), schedule.getUserName(), schedule.getTitle(), schedule.getContents(), schedule.getCreatedAt(), schedule.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getUserName(), findSchedule.getTitle(), findSchedule.getContents(), findSchedule.getCreatedAt(), findSchedule.getUpdatedAt());
    }

    @Transactional
    public void updateContents(Long id, String title) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        findSchedule.updateContents(title);
    }

    @Transactional
    public void deleteSchedule(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(findSchedule);
    }
}
