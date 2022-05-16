package com.colecta.menu.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colecta.menu.entities.Restaurante;
import com.colecta.menu.enums.ErrorMessage;
import com.colecta.menu.repository.RestauranteRepository;

@Service
public class RestauranteService {
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Transactional
	public List<Restaurante> addRestaurantes(List<Restaurante> restaurantes){
		return restauranteRepository.saveAll(restaurantes);
	}
	
	@Transactional
	public Restaurante addRestaurante(Restaurante restaurante) {
		return restauranteRepository.save(restaurante);
	}
	
	@Transactional
	public List<Restaurante> getRestaurantes(){
		return restauranteRepository.findAll();
	}
	
	@Transactional
	public Restaurante getRestaurante(Long id) throws EntityNotFoundException{
		Optional<Restaurante> restaurantesEncontrados = restauranteRepository.findById(id);
		if(restaurantesEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RESTAURANTE_NO_ENCONTRADO.getMensaje());
		}
		return restaurantesEncontrados.get();
	}
	
	@Transactional
	public Restaurante updateRestaurante(Long id, Restaurante restaurante) throws EntityNotFoundException{
		Optional<Restaurante> restaurantesEncontrados = restauranteRepository.findById(id);
		if(restaurantesEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RESTAURANTE_NO_ENCONTRADO.getMensaje());
		}
		restaurante.setId(restaurantesEncontrados.get().getId());
		return restauranteRepository.save(restaurante);
	}
	
	@Transactional
	public void deleteRestaurante(Long id) throws EntityNotFoundException{
		Optional<Restaurante> restaurantesEncontrados = restauranteRepository.findById(id);
		if(restaurantesEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RESTAURANTE_NO_ENCONTRADO.getMensaje());
		}
		restauranteRepository.delete(restaurantesEncontrados.get());
	}
}
