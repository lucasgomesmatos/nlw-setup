package com.nlw.services;

import com.nlw.common.ApplicationException;
import com.nlw.dtos.HabitCreateDto;
import com.nlw.dtos.HabitDto;
import com.nlw.dtos.HabitWeekDaysDto;
import com.nlw.models.Habit;
import com.nlw.models.HabitWeekDays;
import com.nlw.repositories.HabitRepository;
import com.nlw.repositories.HabitWeekDaysRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    @Autowired
    private HabitWeekDaysRepository habitWeekDaysRepository;

    public List<HabitDto> listarHabits() {

        List<Habit> habits = habitRepository.findAll();

        return habits.stream().map(HabitDto::new).collect(Collectors.toList());
    }

    public HabitDto obterHabitsPorId(Long id) {

        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new ApplicationException("Error: Hábito não encontrado"));

        return new HabitDto(habit);
    }

    public HabitDto salvarHabit(HabitCreateDto habitCreateDto) {

        Habit habit = new Habit();
        copyDtoToEntity(habitCreateDto, habit);
        habit = habitRepository.save(habit);


        return new HabitDto(habit);
    }

    private void copyDtoToEntity(HabitCreateDto habitCreateDto, Habit habit) {
        BeanUtils.copyProperties(habitCreateDto, habit);
        habit.setCreated_ad(OffsetDateTime.now());

    }

//    private Habit obterHabitsPorId(Long id) {
//        return habitRepository.findById(id)
//                .orElseThrow(() -> new ApplicationException("Error: Hábito não encontrado"));
//    }

//    @Transactional
//    public Habit salvar(HabitDto habitDto) {
//
//        List<HabitWeekDays> habitWeekDaysList = new ArrayList<>();
//
//        for (int i = 0; i < habitDto.getHabitWeekDays().size(); i++) {
//            HabitWeekDays habitWeekDays = new HabitWeekDays(i);
//
//            habitWeekDaysRepository.save(habitWeekDays);
//            habitWeekDaysList.add(habitWeekDays);
//        }
//
//        System.out.println(habitWeekDaysList);
//
//        Habit habit = Habit.builder()
//                .title(habitDto.getTitle())
//                .created_ad(OffsetDateTime.now())
//                .build();
//
//        habitRepository.save(habit);
//
//
//        return habit;
//    }
//
//    public List<Habit> listar() {
//
//        return habitRepository.findAll();
//    }
//
//    public Habit atualizar(HabitDto habitDto, Long id) {
//        Habit habit = obterHabitsPorId(id);
//
//        BeanUtils.copyProperties(habitDto, habit);
//        habit.setCreated_ad(OffsetDateTime.now());
//
//        return habitRepository.save(habit);
//    }
}
