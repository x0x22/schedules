package com.sparta.schedules.repository;

import com.sparta.schedules.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    public final Map<Long, Schedule> scheduleList = new HashMap<>();

    @Override
    public Schedule saveSchedule(Schedule schedule) {

        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        schedule.setId(scheduleId);

        scheduleList.put(scheduleId, schedule);

        return schedule;
    }
}
