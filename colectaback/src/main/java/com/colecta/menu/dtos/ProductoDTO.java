package com.colecta.menu.dtos;

public class ProductoDTO {
	private Long id;
	private RecetaDTO receta;
	private int cantidad;
	private RestauranteDTO restaurante;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RecetaDTO getReceta() {
		return receta;
	}
	public void setReceta(RecetaDTO receta) {
		this.receta = receta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public RestauranteDTO getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(RestauranteDTO restaurante) {
		this.restaurante = restaurante;
	}
	
}
