package com.nlw.dtos;

import com.nlw.models.HabitWeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitWeekDaysDto {

    private Long id;

    private int week_day;

    public HabitWeekDaysDto(HabitWeekDays habitWeekDays) {
        this.id = habitWeekDays.getId();
        this.week_day = habitWeekDays.getWeek_day();
    }
}
