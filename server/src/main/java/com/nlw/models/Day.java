package com.nlw.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private OffsetDateTime date;

    @JoinTable(name = "day_habit",
            joinColumns = @JoinColumn(name = "day_fk", unique = true),
            inverseJoinColumns = @JoinColumn(name = "habit_fk", unique = true)
    )
    @ManyToMany
    private Set<Habit> habits;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Day day = (Day) o;
        return id != null && Objects.equals(id, day.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
