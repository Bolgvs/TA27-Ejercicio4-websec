package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Facultad;
import com.example.demo.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/facultad")
	public List<Facultad> listarFacultad(){
		return facultadServiceImpl.listarFacultad();
	}
	
	
	@PostMapping("/facultad")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {
		
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	@GetMapping("/facultad/{id}")
	public Facultad Facultad(@PathVariable(name="id") int id) {
		
		Facultad Facultad = new Facultad();
		
		Facultad = facultadServiceImpl.facultad(id);
		
		return Facultad;
	}
	
	@PutMapping("/facultad/{id}")
	public Facultad actualizarFacultad(@PathVariable(name="id")int id,@RequestBody Facultad Facultad) {
		
		Facultad Facultadseleccionado = new Facultad();
		Facultad Facultadactualizado = new Facultad();
		
		Facultadseleccionado = facultadServiceImpl.facultad(id);
		
		Facultadseleccionado.setNombre(Facultad.getNombre());
		Facultadseleccionado.setEquipos(Facultad.getEquipos());
		Facultadseleccionado.setInvestigadores(Facultad.getInvestigadores());
		
		Facultadactualizado = facultadServiceImpl.actualizarFacultad(Facultadseleccionado);
		
		return Facultadactualizado;
	}
	
	@DeleteMapping("/facultad/{id}")
	public void eleiminarFacultad(@PathVariable(name="id")int id) {
		facultadServiceImpl.eliminarFacultad(id);
	}
}
