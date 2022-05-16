package com.colecta.menu.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colecta.menu.entities.Producto;
import com.colecta.menu.entities.Receta;
import com.colecta.menu.enums.ErrorMessage;
import com.colecta.menu.repository.ProductoRepository;
import com.colecta.menu.repository.RecetaRepository;

@Service
public class RecetaProductoService {
	@Autowired
	private RecetaRepository recetaRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Transactional
	public Producto addProducto(Long recetaId, Long productoId) throws EntityNotFoundException {
		Optional<Receta> recetasEncontradas = recetaRepository.findById(recetaId);
		if(recetasEncontradas.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RECETA_NO_ENCONTRADA.getMensaje());
		}
		Optional<Producto> productosEncontrados = productoRepository.findById(productoId);
		if(productosEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.PRODUCTO_NO_ENCONTRADO.getMensaje());
		}
		recetasEncontradas.get().getProductos().add(productosEncontrados.get());
		return productosEncontrados.get();
	}
	
	@Transactional
	public List<Producto> getProductos(Long recetaId) throws EntityNotFoundException{
		Optional<Receta> recetasEncontradas = recetaRepository.findById(recetaId);
		if(recetasEncontradas.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RECETA_NO_ENCONTRADA.getMensaje());
		}
		return recetasEncontradas.get().getProductos();
	}
	
	@Transactional
	public Producto getProducto(Long recetaId, Long productoId) throws Exception, EntityNotFoundException{
		Optional<Receta> recetasEncontradas = recetaRepository.findById(recetaId);
		if(recetasEncontradas.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RECETA_NO_ENCONTRADA.getMensaje());
		}
		Optional<Producto> productosEncontrados = productoRepository.findById(productoId);
		if(productosEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.PRODUCTO_NO_ENCONTRADO.getMensaje());
		}
		if(recetasEncontradas.get().getProductos().contains(productosEncontrados.get())) {
			return productosEncontrados.get();
		}
		throw new Exception("Este producto no esta relacionado con la receta");
	}
	
	@Transactional
	public void removeProducto(Long recetaId, Long productoId) throws Exception, EntityNotFoundException{
		Optional<Receta> recetasEncontradas = recetaRepository.findById(recetaId);
		if(recetasEncontradas.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.RECETA_NO_ENCONTRADA.getMensaje());
		}
		Optional<Producto> productosEncontrados = productoRepository.findById(productoId);
		if(productosEncontrados.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.PRODUCTO_NO_ENCONTRADO.getMensaje());
		}
		if(recetasEncontradas.get().getProductos().contains(productosEncontrados.get())) {
			recetasEncontradas.get().getProductos().remove(productosEncontrados.get());
		}
		throw new Exception("Este producto no esta relacionado con la receta");
	}
}
