package com.colecta.menu.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colecta.menu.entities.Producto;
import com.colecta.menu.entities.Restaurante;
import com.colecta.menu.enums.ErrorMessage;
import com.colecta.menu.repository.ProductoRepository;
import com.colecta.menu.repository.RestauranteRepository;

@Service
public class RestauranteProductoService {
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Transactional
	public Producto addProducto(Long restauranteId, Long productoId) throws EntityNotFoundException {
		Optional<Restaurante> restaurantesEncontrados = restauranteRepository.findById(restauranteId);
		if(restaurantesEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RESTAURANTE_NO_ENCONTRADO.getMensaje());
		}
		Optional<Producto> productosEncontrados = productoRepository.findById(productoId);
		if(productosEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.PRODUCTO_NO_ENCONTRADO.getMensaje());
		}
		restaurantesEncontrados.get().getProductos().add(productosEncontrados.get());
		return productosEncontrados.get();
	}
	
	@Transactional
	public List<Producto> getProductos(Long restauranteId) throws EntityNotFoundException{
		Optional<Restaurante> restaurantesEncontrados = restauranteRepository.findById(restauranteId);
		if(restaurantesEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RESTAURANTE_NO_ENCONTRADO.getMensaje());
		}
		return restaurantesEncontrados.get().getProductos();
	}
	
	@Transactional
	public Producto getProducto(Long restauranteId, Long productoId) throws Exception, EntityNotFoundException{
		Optional<Restaurante> restaurantesEncontrados = restauranteRepository.findById(restauranteId);
		if(restaurantesEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RESTAURANTE_NO_ENCONTRADO.getMensaje());
		}
		Optional<Producto> productosEncontrados = productoRepository.findById(productoId);
		if(productosEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.PRODUCTO_NO_ENCONTRADO.getMensaje());
		}
		if(restaurantesEncontrados.get().getProductos().contains(productosEncontrados.get())) {
			return productosEncontrados.get();
		}
		throw new Exception("Este producto no esta relacionado con el restaurante");
	}
	
	@Transactional
	public void removeProducto(Long restauranteId, Long productoId) throws Exception, EntityNotFoundException{
		Optional<Restaurante> restaurantesEncontrados = restauranteRepository.findById(restauranteId);
		if(restaurantesEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RESTAURANTE_NO_ENCONTRADO.getMensaje());
		}
		Optional<Producto> productosEncontrados = productoRepository.findById(productoId);
		if(productosEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.PRODUCTO_NO_ENCONTRADO.getMensaje());
		}
		if(restaurantesEncontrados.get().getProductos().contains(productosEncontrados.get())) {
			restaurantesEncontrados.get().getProductos().remove(productosEncontrados.get());
		}
		throw new Exception("Este producto no esta relacionado con el restaurante");
	}
}
