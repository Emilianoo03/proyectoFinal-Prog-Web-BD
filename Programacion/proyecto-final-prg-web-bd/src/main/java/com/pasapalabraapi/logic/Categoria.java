package com.pasapalabraapi.logic;

import java.util.ArrayList;

public class Categoria {
	private String nombre;
	
	private ArrayList<Palabra> palabra;
	
	public Categoria(String nombre, ArrayList<Palabra> palabra) {
		super();
		this.nombre = nombre;
		this.palabra = palabra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Palabra> getPalabra() {
		return palabra;
	}

	public void setPalabra(ArrayList<Palabra> palabra) {
		this.palabra = palabra;
	}
	
	
	
}
