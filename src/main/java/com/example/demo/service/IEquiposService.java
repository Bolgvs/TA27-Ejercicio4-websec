package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Equipos;

public interface IEquiposService {
	
	public List<Equipos> listarEquipos();
	
	public Equipos guardarEquipos(Equipos equipos);
	
	public Equipos equipos(int id);
	
	public Equipos actualizarEquipos(Equipos equipos);
	
	public void eliminarEquipos(int id);
	
}

