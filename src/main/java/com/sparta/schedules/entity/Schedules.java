package com.sparta.schedules.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
// 게터 메서드 자동생성
@Getter
// 모든 필드를 매개변수로 하는 생성자 생성
@AllArgsConstructor

public class Schedules {

    private Long schedules_id;
    private String user_name;
    private String passwords;
    private String plan;
    private String content;
    private Date schedules_date;
    private Date create_date;
    private Date edit_date;

}
