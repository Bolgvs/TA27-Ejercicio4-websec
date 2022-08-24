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

import com.example.demo.dto.Equipos;
import com.example.demo.service.EquiposServiceImpl;

@RestController
@RequestMapping("/api")
public class EquiposController {

	@Autowired
	EquiposServiceImpl equiposServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipos> listarEquipos(){
		return equiposServiceImpl.listarEquipos();
	}
	
	
	@PostMapping("/equipos")
	public Equipos salvarEquipos(@RequestBody Equipos equipos) {
		
		return equiposServiceImpl.guardarEquipos(equipos);
	}
	
	@GetMapping("/equipos/{id}")
	public Equipos Equipos(@PathVariable(name="id") int id) {
		
		Equipos Equipos = new Equipos();
		
		Equipos = equiposServiceImpl.equipos(id);
		
		return Equipos;
	}
	
	@PutMapping("/equipos/{id}")
	public Equipos actualizarEquipos(@PathVariable(name="id")int id,@RequestBody Equipos Equipos) {
		
		Equipos Equiposseleccionado = new Equipos();
		Equipos Equiposactualizado = new Equipos();
		
		Equiposseleccionado = equiposServiceImpl.equipos(id);
		
		Equiposseleccionado.setNombre(Equipos.getNombre());
		Equiposseleccionado.setReserva(Equipos.getReserva());
		Equiposseleccionado.setFacultad(Equipos.getFacultad());
		
		Equiposactualizado = equiposServiceImpl.actualizarEquipos(Equiposseleccionado);
		
		return Equiposactualizado;
	}
	
	@DeleteMapping("/equipos/{id}")
	public void eleiminarEquipos(@PathVariable(name="id")int id) {
		equiposServiceImpl.eliminarEquipos(id);
	}
}