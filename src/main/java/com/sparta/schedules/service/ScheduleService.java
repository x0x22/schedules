package com.sparta.schedules.service;

import com.sparta.schedules.dto.ScheduleRequestDto;
import com.sparta.schedules.dto.ScheduleResponseDto;

import java.util.Date;
import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);

    List<ScheduleResponseDto> findAllSchedules();

    ScheduleResponseDto findScheduleById(Long id);

    ScheduleResponseDto updateSchedule(Long id, String passwords, String todo, String content, Date todoDate);

    void deleteSchedule(Long id);

//    ScheduleResponseDto findScheduleByName(String name);
}
