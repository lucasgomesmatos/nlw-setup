package com.nlw.dtos;

import com.nlw.models.HabitWeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitCreateDto {

    private String title;

    private List<Long> habitWeekDays;


}
