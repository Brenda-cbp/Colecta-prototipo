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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.colecta.menu.dtos.ProductoDTO;
import com.colecta.menu.dtos.RestauranteProductoDTO;
import com.colecta.menu.entities.Producto;
import com.colecta.menu.service.RestauranteProductoService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteProductoController {

	@Autowired
	private RestauranteProductoService restauranteProductoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/{restauranteId}/productos/{productoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public RestauranteProductoDTO encontrarProducto(@PathVariable("productoId") Long productoId, 
			@PathVariable("restauranteId") Long restauranteId) throws Exception, EntityNotFoundException{
		Producto producto = restauranteProductoService.getProducto(restauranteId, productoId);
		return modelMapper.map(producto, RestauranteProductoDTO.class);
	}
	
	@GetMapping(value = "/{restauranteId}/productos/")
	@ResponseStatus(code = HttpStatus.OK)
	public List<RestauranteProductoDTO> entontrarProductos(@PathVariable("restauranteId") Long restauranteId) throws EntityNotFoundException{
		List<Producto> productos = restauranteProductoService.getProductos(restauranteId);
		return modelMapper.map(productos, new TypeToken<List<RestauranteProductoDTO>>() {}.getType());
	}
	
	@PostMapping(value = "/{restauranteId}/productos/{productoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProductoDTO agregarProducto(@PathVariable("productoId") Long productoId, 
			@PathVariable("restauranteId") Long restauranteId) throws EntityNotFoundException{
		Producto producto = restauranteProductoService.addProducto(restauranteId, productoId);
		return modelMapper.map(producto, ProductoDTO.class);
	}
	
	@DeleteMapping(value = "/{restauranteId}/productos/{productoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removerProducto(@PathVariable("productoId") Long productoId, 
			@PathVariable("restauranteId") Long restauranteId) throws Exception, EntityNotFoundException{
		restauranteProductoService.removeProducto(restauranteId, productoId);
	}
}
