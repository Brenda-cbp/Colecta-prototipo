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
import com.colecta.menu.dtos.RecetaProductoDTO;
import com.colecta.menu.entities.Producto;
import com.colecta.menu.service.RecetaProductoService;

@RestController
@RequestMapping("/recetas")
public class RecetaProductoController {
	@Autowired
	private RecetaProductoService recetaProductoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/{recetaId}/productos/{productoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public RecetaProductoDTO encontrarProducto(@PathVariable("productoId") Long productoId, 
			@PathVariable("recetaId") Long recetaId) throws Exception, EntityNotFoundException{
		Producto producto = recetaProductoService.getProducto(recetaId, productoId);
		return modelMapper.map(producto, RecetaProductoDTO.class);
	}
	
	@GetMapping(value = "/{recetaId}/productos/")
	@ResponseStatus(code = HttpStatus.OK)
	public List<RecetaProductoDTO> entontrarProductos(@PathVariable("recetaId") Long recetaId) throws EntityNotFoundException{
		List<Producto> productos = recetaProductoService.getProductos(recetaId);
		return modelMapper.map(productos, new TypeToken<List<RecetaProductoDTO>>() {}.getType());
	}
	
	@PostMapping(value = "/{recetaId}/productos/{productoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProductoDTO agregarProducto(@PathVariable("productoId") Long productoId, 
			@PathVariable("recetaId") Long recetaId) throws EntityNotFoundException{
		Producto producto = recetaProductoService.addProducto(recetaId, productoId);
		return modelMapper.map(producto, ProductoDTO.class);
	}
	
	@DeleteMapping(value = "/{recetaId}/productos/{productoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removerProducto(@PathVariable("productoId") Long productoId, 
			@PathVariable("recetaId") Long recetaId) throws Exception, EntityNotFoundException{
		recetaProductoService.removeProducto(recetaId, productoId);
	}
}
