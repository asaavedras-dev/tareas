package com.copeuch.tarea;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.copeuch.tarea.model.Tarea;
import com.copeuch.tarea.repository.ITareaRepository;

public class TareaRepositoryTest {
	
	ITareaRepository tareaRepository;
	
    @BeforeEach
    void setUp(){
    	tareaRepository = mock(ITareaRepository.class);
    }
	
	@Test
	void crearTareaTest() {
		Tarea tarea = new Tarea(3,"Tarea1",new Date(),true);
		when(tareaRepository.save(tarea)).thenReturn(tarea);
		Tarea tareaGuardada = tareaRepository.save(tarea);
		Assertions.assertThat(tareaGuardada.getId()).isGreaterThan(0);
	}
	
	@Test
	void obtenerTareasTest() {
		Tarea tarea4 = new Tarea(4,"Tarea4",new Date(),true);
		Tarea tarea5 = new Tarea(5,"Tarea5",new Date(),true);
		List<Tarea> tareas = new ArrayList<>();
		List<Tarea> tareasResultado = new ArrayList<>();
		tareas.add(tarea4);
		tareas.add(tarea5);
		when(tareaRepository.findAll()).thenReturn(tareas);
		tareasResultado = tareaRepository.findAll();
		Assertions.assertThat(tareasResultado).containsAll(tareas);
	}
}
