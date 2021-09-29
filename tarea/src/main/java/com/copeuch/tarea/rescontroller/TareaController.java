package com.copeuch.tarea.rescontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.copeuch.tarea.model.Tarea;
import com.copeuch.tarea.services.ITareaService;

import io.swagger.annotations.Api;


@CrossOrigin(origins="http://localhost:3000")
@Api(tags="Tareas API")
@RestController
@RequestMapping("/tareas")
public class TareaController {
	
	@Autowired
	private ITareaService iTareaService;
	
	
	@GetMapping("")
	public ResponseEntity<?> obtenerTareas() {
		List<Tarea> tareas = iTareaService.obtenerTareas();
		return ResponseEntity.ok(tareas);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarTarea(@PathVariable Integer id) {
		iTareaService.eliminarTarea(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("")
	public ResponseEntity<?> agregarTarea(@Valid @RequestBody Tarea tarea) {
		iTareaService.agregarTarea(tarea);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("")
	public ResponseEntity<?> editarTarea(@Valid @RequestBody Tarea tarea) {
		iTareaService.actualizarTarea(tarea);
		return ResponseEntity.ok().build();
	}
}
