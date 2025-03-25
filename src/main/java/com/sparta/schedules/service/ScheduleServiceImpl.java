package com.sparta.schedules.service;

import com.sparta.schedules.dto.ScheduleRequestDto;
import com.sparta.schedules.dto.ScheduleResponseDto;
import com.sparta.schedules.entity.Schedule;
import com.sparta.schedules.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service

public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {

        Schedule schedule = new Schedule(dto.getUserName(), dto.getPasswords(), dto.getTodo(), dto.getContent(), dto.getTodoDate());

        Schedule savedSchedule = scheduleRepository.saveSchedule(schedule);


        return new ScheduleResponseDto(savedSchedule);
    }
}
