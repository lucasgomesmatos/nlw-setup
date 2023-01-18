package com.nlw.controllers;

import com.nlw.dtos.HabitDto;
import com.nlw.models.Habit;
import com.nlw.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/habits")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @PostMapping
    public ResponseEntity<Habit> salvar(@RequestBody @Valid HabitDto habitDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(habitService.salvar(habitDto));
    }

    @GetMapping
    public ResponseEntity<List<Habit>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(habitService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habit> atualizar(
            @RequestBody @Valid HabitDto habitDto,
            @PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(habitService.atualizar(habitDto, id));
    }
}
