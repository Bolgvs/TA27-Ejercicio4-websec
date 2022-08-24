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

import com.example.demo.dto.Investigadores;
import com.example.demo.service.InvestigadoresServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadoresController {

	@Autowired
	InvestigadoresServiceImpl investigadoresServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigadores> listarInvestigadores(){
		return investigadoresServiceImpl.listarInvestigadores();
	}
	
	
	@PostMapping("/investigadores")
	public Investigadores salvarInvestigadores(@RequestBody Investigadores investigadores) {
		
		return investigadoresServiceImpl.guardarInvestigadores(investigadores);
	}
	
	
	@GetMapping("/investigadores/{id}")
	public Investigadores Investigadores(@PathVariable(name="id") int id) {
		
		Investigadores Investigadores = new Investigadores();
		
		Investigadores = investigadoresServiceImpl.investigadores(id);
		
		return Investigadores;
	}
	
	@PutMapping("/investigadores/{id}")
	public Investigadores actualizarProductos(@PathVariable(name="id")int id,@RequestBody Investigadores Investigadores) {
		
		Investigadores Investigadoresseleccionado = new Investigadores();
		Investigadores Investigadoresactualizado = new Investigadores();
		
		Investigadoresseleccionado= investigadoresServiceImpl.investigadores(id);
		
		Investigadoresseleccionado.setDni(Investigadores.getDni());
		Investigadoresseleccionado.setNomApels(Investigadores.getNomApels());
		Investigadoresseleccionado.setReserva(Investigadores.getReserva());
		Investigadoresseleccionado.setFacultad(Investigadores.getFacultad());
		
		Investigadoresactualizado = investigadoresServiceImpl.actualizarInvestigadores(Investigadoresseleccionado);
		
		return Investigadoresactualizado;
	}
	
	@DeleteMapping("/investigadores/{id}")
	public void eleiminarInvestigadores(@PathVariable(name="id")int id) {
		investigadoresServiceImpl.eliminarInvestigadores(id);
	}
	
}
