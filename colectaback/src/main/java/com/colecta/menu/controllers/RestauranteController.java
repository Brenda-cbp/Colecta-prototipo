package com.colecta.menu.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.colecta.menu.dtos.RestauranteDTO;
import com.colecta.menu.dtos.RestauranteDetailDTO;
import com.colecta.menu.entities.Restaurante;
import com.colecta.menu.service.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public RestauranteDTO crearRestaurante(@RequestBody RestauranteDTO restauranteDTO) throws Exception{
		Restaurante restaurante = restauranteService.addRestaurante(modelMapper.map(restauranteDTO, Restaurante.class));
		return modelMapper.map(restaurante, RestauranteDTO.class);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<RestauranteDetailDTO> encontrarRestaurantes(){
		List<Restaurante> restaurantes = restauranteService.getRestaurantes();
		return modelMapper.map(restaurantes, new TypeToken<List<RestauranteDetailDTO>>() {}.getType());
	}
	
	@GetMapping(value="/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public RestauranteDetailDTO encontrarRestaurante(@PathVariable("id") Long id) throws EntityNotFoundException{
		Restaurante restaurante = restauranteService.getRestaurante(id);
		return modelMapper.map(restaurante, RestauranteDetailDTO.class);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public RestauranteDTO actualizarRestaurante(@PathVariable("id") Long id, @RequestBody RestauranteDTO restauranteDTO) throws EntityNotFoundException{
		Restaurante restaurante = restauranteService.updateRestaurante(id, modelMapper.map(restauranteDTO, Restaurante.class));
		return modelMapper.map(restaurante, RestauranteDTO.class);
	}
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarRestaurante(@PathVariable("id") Long id)  throws EntityNotFoundException{
		restauranteService.deleteRestaurante(id);
	}
}
