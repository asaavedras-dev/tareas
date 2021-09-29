package com.copeuch.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.copeuch.tarea.model.Tarea;

public interface ITareaRepository extends JpaRepository<Tarea, Integer> {

}
