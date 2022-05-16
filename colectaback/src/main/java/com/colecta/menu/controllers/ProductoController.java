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

import com.colecta.menu.dtos.ProductoDTO;
import com.colecta.menu.entities.Producto;
import com.colecta.menu.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductoDTO crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception{
		Producto producto = productoService.addProducto(modelMapper.map(productoDTO, Producto.class));
		return modelMapper.map(producto, ProductoDTO.class);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductoDTO> encontrarProductos(){
		List<Producto> productos = productoService.getProductos();
		return modelMapper.map(productos, new TypeToken<List<ProductoDTO>>() {}.getType());
	}
	
	@GetMapping(value="/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProductoDTO encontrarProducto(@PathVariable("id") Long id) throws EntityNotFoundException{
		Producto producto = productoService.getProducto(id);
		return modelMapper.map(producto, ProductoDTO.class);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ProductoDTO actualizarProducto(@PathVariable("id") Long id, @RequestBody ProductoDTO productoDTO) throws EntityNotFoundException{
		Producto producto = productoService.updateProducto(id, modelMapper.map(productoDTO, Producto.class));
		return modelMapper.map(producto, ProductoDTO.class);
	}
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarProducto(@PathVariable("id") Long id)  throws EntityNotFoundException{
		productoService.deleteProducto(id);
	}
}
