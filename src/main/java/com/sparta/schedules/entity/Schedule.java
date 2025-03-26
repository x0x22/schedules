package com.sparta.schedules.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor

public class Schedule {

    @Setter
    private Long id;
    private String userName;
    private String passwords;
    private String todo;
    private String content;
    private Date todoDate;
    private Date createDate;
    private Date editDate;

    public Schedule(String userName, String passwords, String todo, String content, Date todoDate){
        this.userName = userName;
        this.passwords = passwords;
        this.todo = todo;
        this.content = content;
        this.todoDate = todoDate;
        this.createDate = new Date();
        this.editDate = new Date();

    }

    public void update(String userName, String passwords,String todo,String content,Date todoDate) {
        this.userName = userName;
        this.passwords = passwords;
        this.todo = todo;
        this.content = content;
        this.todoDate = todoDate;
        this.editDate = new Date();
    }

}
