package com.sparta.schedules.controller;

import com.sparta.schedules.dto.ScheduleRequestDto;
import com.sparta.schedules.dto.ScheduleResponseDto;
import com.sparta.schedules.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    //데이터베이스가 아닌 테스트를 위한 임시 저장용도
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    // 호춣해서 사용할 controller API
    @PostMapping
    public ScheduleResponseDto createschedule(@RequestBody ScheduleRequestDto dto) {

        //식별자가 1씩 증가 Collections.max = 최대 값 뽑아냄 (scheduleList.keySet()) 리스트 안 키값 다뽑아
        Long schedule_id = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        // 요청받은 데이터로 schedule객체생성
        Schedule schedule = new Schedule(schedule_id, dto.getUser_name(), dto.getPasswords(), dto.getPlan(), dto.getContent(), dto.getSchedule_date(), new Date(), null);

        //Inmemory DB에 schedule 저장
        scheduleList.put(schedule_id, schedule);

        return new ScheduleResponseDto(schedule);
    }

    //schedule_id를 사용해서 일정 단건 조회
    @GetMapping("/{schedule_id}")
    public ScheduleResponseDto findScheduleById(@PathVariable Long schedule_id) {

        Schedule schedule = scheduleList.get(schedule_id);

        return new ScheduleResponseDto(schedule);
    }

    //전체 조회 리스트 형식이라 방법이 고민되는데...
    //DB연결하면 하는걸로
    @GetMapping
    private ScheduleRequestDto AllSchedule(@RequestBody){

    }

    //일정 수정기능
    @PutMapping("/{schedule_id}")
    public ScheduleResponseDto updateScheduleById(
            @PathVariable Long schedule_id,
            @RequestBody ScheduleRequestDto dto
    ){
        Schedule schedule = scheduleList.get(schedule_id);

        schedule.update(dto);

        return new ScheduleResponseDto(schedule);
    }

    //일정 선택 삭제
    @DeleteMapping("/{schedule_id}")
    public void deleteSchedule(@PathVariable Long schedule_id) {

        scheduleList.remove(schedule_id);

    }
}


