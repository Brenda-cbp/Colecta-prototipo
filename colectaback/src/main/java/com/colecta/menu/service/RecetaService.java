package com.colecta.menu.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colecta.menu.repository.RecetaRepository;
import com.colecta.menu.entities.Receta;
import com.colecta.menu.enums.ErrorMessage;

@Service
public class RecetaService {
	@Autowired
	private RecetaRepository recetaRepository;
	
	@Transactional
	public List<Receta> addRecetas(List<Receta> recetas){
		return recetaRepository.saveAll(recetas);
	}
	
	@Transactional
	public Receta addReceta(Receta receta) {
		return recetaRepository.save(receta);
	}
	
	@Transactional
	public List<Receta> getRecetas(){
		return recetaRepository.findAll();
	}
	
	@Transactional
	public Receta getReceta(Long id) throws EntityNotFoundException{
		Optional<Receta> recetasEncontradas = recetaRepository.findById(id);
		if(recetasEncontradas.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RECETA_NO_ENCONTRADA.getMensaje());
		}
		return recetasEncontradas.get();
	}
	
	@Transactional
	public Receta updateReceta(Long id, Receta receta) throws EntityNotFoundException{
		Optional<Receta> recetasEncontradas = recetaRepository.findById(id);
		if(recetasEncontradas.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RECETA_NO_ENCONTRADA.getMensaje());
		}
		receta.setId(recetasEncontradas.get().getId());
		return recetaRepository.save(receta);
	}
	
	@Transactional
	public void deleteReceta(Long id) throws EntityNotFoundException{
		Optional<Receta> recetasEncontradas = recetaRepository.findById(id);
		if(recetasEncontradas.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RECETA_NO_ENCONTRADA.getMensaje());
		}
		recetaRepository.delete(recetasEncontradas.get());
	}
}
