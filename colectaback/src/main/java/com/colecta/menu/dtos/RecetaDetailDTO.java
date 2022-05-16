package com.colecta.menu.dtos;

import java.util.ArrayList;
import java.util.List;

public class RecetaDetailDTO extends RecetaDTO{
	private List<RecetaProductoDTO> productos = new ArrayList<RecetaProductoDTO>();

	public List<RecetaProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<RecetaProductoDTO> productos) {
		this.productos = productos;
	}
}
