package com.sparta.schedules.dto;

import lombok.Getter;

import java.util.Date;

@Getter

public class scheduleResponseDto {
    // 응답할 데이터
    private Long schedules_id;
    private String user_name;
    private String plan;
    private String content;
    private Date schedules_date;
    private Date create_date;

}
