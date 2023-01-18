package com.nlw.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class HabitDto {

    @NotBlank
    private String title;

}
