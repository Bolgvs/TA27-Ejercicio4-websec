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

import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reserva")
	public List<Reserva> listarReserva(){
		return reservaServiceImpl.listarReserva();
	}
	
	
	@PostMapping("/reserva")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {
		
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	
	@GetMapping("/reserva/{id}")
	public Reserva Venta(@PathVariable(name="id") int id) {
		
		Reserva Reserva = new Reserva();
		
		Reserva = reservaServiceImpl.reserva(id);
		
		return Reserva;
	}
	
	@PutMapping("/reserva/{id}")
	public Reserva actualizarVenta(@PathVariable(name="id")int id,@RequestBody Reserva reserva) {
		
		Reserva Reservaseleccionado = new Reserva();
		Reserva Reservaactualizado = new Reserva();
		
		Reservaseleccionado= reservaServiceImpl.reserva(id);
		
		
		Reservaseleccionado.setDni(reserva.getDni());
		Reservaseleccionado.setNumSerie(reserva.getNumSerie());
		Reservaseleccionado.setComienzo(reserva.getComienzo());
		Reservaseleccionado.setFin(reserva.getFin());
		
		Reservaactualizado = reservaServiceImpl.actualizarReserva(Reservaseleccionado);
		
		return Reservaactualizado;
	}
	
	@DeleteMapping("/reserva/{id}")
	public void eleiminarReserva(@PathVariable(name="id")int id) {
		reservaServiceImpl.eliminarReserva(id);
	}
}
