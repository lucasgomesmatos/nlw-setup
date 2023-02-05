package com.nlw.dtos;

import com.nlw.models.Habit;
import com.nlw.models.HabitWeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitDto {

    private Long id;
    private String title;
    private OffsetDateTime created_ad;

    public HabitDto(Habit habit) {
        this.id = habit.getId();
        this.title = habit.getTitle();
        this.created_ad = habit.getCreated_ad();
    }


}
