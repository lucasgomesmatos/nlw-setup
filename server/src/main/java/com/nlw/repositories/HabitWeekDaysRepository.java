package com.nlw.repositories;

import com.nlw.models.HabitWeekDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HabitWeekDaysRepository extends JpaRepository<HabitWeekDays, Long> {

}
