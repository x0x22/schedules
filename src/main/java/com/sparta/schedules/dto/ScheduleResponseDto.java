package com.sparta.schedules.dto;

import com.sparta.schedules.entity.Schedule;
import lombok.Getter;

import java.util.Date;

@Getter

public class ScheduleResponseDto {
    // 응답할 데이터
    private Long schedule_id;
    private String user_name;
    private String plan;
    private String content;
    private Date schedule_date;
    private Date create_date;


    //생성자
    public ScheduleResponseDto(Schedule schedule){

        this.schedule_id = schedule.getSchedule_id();
        this.user_name = schedule.getUser_name();
        this.plan = schedule.getPlan();
        this.content = schedule.getContent();
        this.schedule_date = schedule.getSchedule_date();
        this.create_date = schedule.getCreate_date();

    }

}
