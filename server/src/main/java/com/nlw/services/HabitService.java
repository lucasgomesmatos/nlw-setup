package com.nlw.services;

import com.nlw.common.ApplicationException;
import com.nlw.dtos.HabitDto;
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

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    @Autowired
    private HabitWeekDaysRepository habitWeekDaysRepository;

    private Habit obterHabitsPorId(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new ApplicationException("Error: Hábito não encontrado"));
    }

    @Transactional
    public Habit salvar(HabitDto habitDto) {

        List<HabitWeekDays> listhabitWeekDay = new ArrayList<>();

        for (int i = 0; i < habitDto.getHabitWeekDays().size(); i++) {
            var habitWeekDay = new HabitWeekDays(i);
            listhabitWeekDay.add(habitWeekDaysRepository.save(habitWeekDay));
        }

        var habit = Habit.builder()
                .title(habitDto.getTitle())
                .created_ad(OffsetDateTime.now())
                .habitWeekDays(listhabitWeekDay.get().getWeek_day())
                .build();

        var newHabit = habitRepository.save(habit);



        return habit;
    }

    public List<Habit> listar() {

        return habitRepository.findAll();
    }

    public Habit atualizar(HabitDto habitDto, Long id) {
        Habit habit = obterHabitsPorId(id);

        BeanUtils.copyProperties(habitDto, habit);
        habit.setCreated_ad(OffsetDateTime.now());

        return habitRepository.save(habit);
    }
}
