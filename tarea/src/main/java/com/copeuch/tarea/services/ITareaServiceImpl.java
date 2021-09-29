package com.copeuch.tarea.services;

import com.copeuch.tarea.model.Tarea;
import com.copeuch.tarea.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ITareaServiceImpl implements ITareaService {

	private ITareaRepository tareaRepository;

    public ITareaServiceImpl(ITareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
	
	
	public List<Tarea> obtenerTareas(){
		return tareaRepository.findAll();
	}
	
	public void agregarTarea(Tarea tarea) {
		tareaRepository.save(tarea);
	}
	
	public void eliminarTarea(Integer id) {
		tareaRepository.deleteById(id);
	}
	
	public void actualizarTarea(Tarea tarea) {
		tareaRepository.save(tarea);
	}
	
	

}
