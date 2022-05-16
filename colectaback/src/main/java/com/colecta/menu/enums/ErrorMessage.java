package com.colecta.menu.enums;

public enum ErrorMessage {
	RECETA_NO_ENCONTRADA("La receta con el id dado no fue encontrada."),
	PRODUCTO_NO_ENCONTRADO("El producto con el id dado no fue encontrado."),
	RESTAURANTE_NO_ENCONTRADO("El restaurante con el id dado no fue encontrado");

	private final String mensaje;
	
	ErrorMessage(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
