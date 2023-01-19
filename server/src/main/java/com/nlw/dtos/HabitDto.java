package com.nlw.dtos;

import com.nlw.models.HabitWeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitDto {

    @NotBlank
    private String title;

    @NotNull
    private List<Integer> habitWeekDays;

}
