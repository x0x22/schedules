package com.sparta.schedules.dto;

import lombok.Getter;

import java.util.Date;

@Getter
// 요청 받을 데이터
public class ScheduleRequestDto {

    private String userName;
    private String passwords;
    private String todo;
    private String content;
    private Date todoDate;


}
