package com.colecta.menu.dtos;

import java.util.ArrayList;
import java.util.List;

public class RestauranteDetailDTO extends RestauranteDTO{
	private List<RestauranteProductoDTO> productos = new ArrayList<RestauranteProductoDTO>();

	public List<RestauranteProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<RestauranteProductoDTO> productos) {
		this.productos = productos;
	}
}
