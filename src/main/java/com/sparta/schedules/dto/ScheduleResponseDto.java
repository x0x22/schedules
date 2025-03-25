package com.sparta.schedules.dto;

import com.sparta.schedules.entity.Schedule;
import lombok.Getter;

import java.util.Date;

@Getter

public class ScheduleResponseDto {
    // 응답할 데이터
    private Long id;
    private String userName;
    private String plan;
    private String content;
    private Date scheduleDate;
    private Date createDate;
    private Date editDate;



    //생성자
    public ScheduleResponseDto(Schedule schedule){

        this.id = schedule.getId();
        this.userName = schedule.getUserName();
        this.plan = schedule.getPlan();
        this.content = schedule.getContent();
        this.scheduleDate = schedule.getScheduleDate();
        this.createDate = schedule.getCreateDate();
        this.editDate =  schedule.getEditDate();
    }

}
