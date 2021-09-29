package com.copeuch.tarea.services;

import java.util.List;

import com.copeuch.tarea.model.Tarea;

public interface ITareaService {
	
	public List<Tarea> obtenerTareas();
	
	public void agregarTarea(Tarea tarea);
	
	public void eliminarTarea(Integer id);
	
	public void actualizarTarea(Tarea tarea);
}
