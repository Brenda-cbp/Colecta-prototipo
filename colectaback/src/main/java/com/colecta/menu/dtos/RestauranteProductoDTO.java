package com.colecta.menu.dtos;

public class RestauranteProductoDTO {
	private Long id;
	private RecetaDTO receta;
	private int cantidad;
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
}
