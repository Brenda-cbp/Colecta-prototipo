package com.colecta.menu.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colecta.menu.entities.Producto;
import com.colecta.menu.enums.ErrorMessage;
import com.colecta.menu.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	@Transactional
	public List<Producto> addProductos(List<Producto> productos){
		return productoRepository.saveAll(productos);
	}
	
	@Transactional
	public Producto addProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	@Transactional
	public List<Producto> getProductos(){
		return productoRepository.findAll();
	}
	
	@Transactional
	public Producto getProducto(Long id) throws EntityNotFoundException{
		Optional<Producto> productosEncontrados = productoRepository.findById(id);
		if(productosEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.PRODUCTO_NO_ENCONTRADO.getMensaje());
		}
		return productosEncontrados.get();
	}
	
	@Transactional
	public Producto updateProducto(Long id, Producto producto) throws EntityNotFoundException{
		Optional<Producto> productosEncontrados = productoRepository.findById(id);
		if(productosEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.PRODUCTO_NO_ENCONTRADO.getMensaje());
		}
		producto.setId(productosEncontrados.get().getId());
		return productoRepository.save(producto);
	}
	
	@Transactional
	public void deleteProducto(Long id) throws EntityNotFoundException{
		Optional<Producto> productosEncontrados = productoRepository.findById(id);
		if(productosEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.PRODUCTO_NO_ENCONTRADO.getMensaje());
		}
		productoRepository.delete(productosEncontrados.get());
	}
}
