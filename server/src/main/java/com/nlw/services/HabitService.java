package com.nlw.services;

import com.nlw.common.ApplicationException;
import com.nlw.dtos.HabitDto;
import com.nlw.models.Habit;
import com.nlw.repositories.HabitRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    private Habit obterHabitsPorId(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new ApplicationException("Error: Hábito não encontrado"));
    }

    @Transactional
    public Habit salvar(HabitDto habitDto) {

        var habit = new Habit();
        BeanUtils.copyProperties(habitDto, habit);
        habit.setCreated_ad(OffsetDateTime.now());

        return habitRepository.save(habit);
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
