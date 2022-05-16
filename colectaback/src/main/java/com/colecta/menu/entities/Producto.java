package com.colecta.menu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto extends EntityClass{
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receta_id")
	private Receta receta;
	@Column
	private int cantidad;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurante_id")
	private Restaurante restaurante;
	
	public Producto() {
		
	}
	
	public Producto(Receta receta, int cantidad, Restaurante restaurante) {
		this.receta = receta;
		this.cantidad = cantidad;
		this.restaurante = restaurante;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}


}
