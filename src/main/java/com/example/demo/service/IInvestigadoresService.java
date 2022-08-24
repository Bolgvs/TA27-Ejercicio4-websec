package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigadores;

public interface IInvestigadoresService {

	public List<Investigadores> listarInvestigadores();
			
	public Investigadores guardarInvestigadores(Investigadores investigadores);	
		
	public Investigadores investigadores(int id);
			
	public Investigadores actualizarInvestigadores(Investigadores investigadores); 
			
	public void eliminarInvestigadores(int id);
	
}
