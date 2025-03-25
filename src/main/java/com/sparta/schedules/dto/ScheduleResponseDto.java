package com.sparta.schedules.dto;

import com.sparta.schedules.entity.Schedule;
import lombok.Getter;

import java.util.Date;

@Getter
//응답할 데이터
public class ScheduleResponseDto {

    private Long id;
    private String userName;
    private String todo;
    private String content;
    private Date todoDate;
    private Date createDate;
    private Date editDate;

    //생성자

    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.userName = schedule.getUserName();
        this.todo = schedule.getTodo();
        this.content = schedule.getContent();
        this.todoDate = schedule.getTodoDate();
        this.createDate = schedule.getCreateDate();
        this.editDate = schedule.getEditDate();
    }

}
