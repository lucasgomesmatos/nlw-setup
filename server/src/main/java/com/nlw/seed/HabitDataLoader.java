package com.nlw.seed;

import com.nlw.models.Habit;
import com.nlw.repositories.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class HabitDataLoader implements CommandLineRunner {

    @Autowired
    private HabitRepository habitRepository;

    @Override
    public void run(String... args) throws Exception {
        loadHabitData();
    }

    private void loadHabitData() {
        if (habitRepository.count() == 0) {
            Habit habit1 = new Habit("Beber 3L de água", OffsetDateTime.now());
            Habit habit2 = new Habit("Acordar 5h da manhã", OffsetDateTime.now());

            habitRepository.save(habit1);
            habitRepository.save(habit2);
        }
        System.out.println(habitRepository.count());
    }
}
