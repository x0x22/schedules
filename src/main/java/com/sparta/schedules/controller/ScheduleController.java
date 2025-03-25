package com.sparta.schedules.controller;

import com.sparta.schedules.dto.ScheduleRequestDto;
import com.sparta.schedules.dto.ScheduleResponseDto;
import com.sparta.schedules.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    //데이터베이스가 아닌 테스트를 위한 임시 저장용도
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    // 호춣해서 사용할 controller API
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createschedule(@RequestBody ScheduleRequestDto dto) {

        //식별자가 1씩 증가 Collections.max = 최대 값 뽑아냄 (scheduleList.keySet()) 리스트 안 키값 다뽑아
        Long id = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        // 요청받은 데이터로 schedule객체생성
        Schedule schedule = new Schedule(id, dto.getUserName(), dto.getPasswords(), dto.getPlan(), dto.getContent(), dto.getScheduleDate(), new Date(), new Date());

        //Inmemory DB에 schedule 저장
        scheduleList.put(id, schedule);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.CREATED);
    }

    //id를 사용해서 일정 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {

        Schedule schedule = scheduleList.get(id);

        // 일정이 없을 경우 404 NOT_FOUND 반환
        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }

    //강의 보고 해결
    //전체 조회
    @GetMapping
    private ResponseEntity<List<ScheduleResponseDto>> AllSchedule() {

        List<ScheduleResponseDto> responseList = new ArrayList<>();

        //HashMap
        for (Schedule schedule : scheduleList.values()) {
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }

        //같은동작을 하는 코드
//        responseList = scheduleList.values().stream().map(ScheduleResponseDto::new).toList();

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    //일정 수정기능
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateScheduleById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto
    ) {
        Schedule schedule = scheduleList.get(id);

        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // 수정시 비밀번호와 일정이 없을경우 BAD_REQUEST
        if (dto.getPasswords() == null || dto.getPlan() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        schedule.update(dto);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule),HttpStatus.OK);
    }

    //일정 선택 삭제
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {

        scheduleList.remove(id);

    }
}


