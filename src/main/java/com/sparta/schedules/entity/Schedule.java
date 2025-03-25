package com.sparta.schedules.entity;

import com.sparta.schedules.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
// 게터 메서드 자동생성
@Getter
// 모든 필드를 매개변수로 하는 생성자 생성
@AllArgsConstructor

public class Schedule {

    private Long id;
    private String userName;
    private String passwords;
    private String plan;
    private String content;
    private Date scheduleDate;
    private Date createDate;
    private Date editDate;

    //수정 메서드
    public void update(ScheduleRequestDto dto){
        this.plan = dto.getPlan();
        this.content = dto.getContent();
        this.scheduleDate = dto.getScheduleDate();
        this.editDate = new Date();
    }

}
