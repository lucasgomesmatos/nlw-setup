package com.nlw.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private OffsetDateTime created_ad;

    @JoinColumn(name = "habit_id")
    @OneToMany
    private List<HabitWeekDays> habitWeekDays = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Habit habit = (Habit) o;
        return id != null && Objects.equals(id, habit.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
