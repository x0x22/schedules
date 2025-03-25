package com.sparta.schedules.dto;

import lombok.Getter;

import java.util.Date;

@Getter

public class ScheduleRequestDto {
    // 요청받을 데이터

    private String user_name;
    private String passwords;
    private String plan;
    private String content;
    private Date schedule_date;

}
