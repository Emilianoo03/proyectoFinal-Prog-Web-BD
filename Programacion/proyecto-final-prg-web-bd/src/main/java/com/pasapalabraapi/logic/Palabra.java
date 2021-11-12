package com.pasapalabraapi.logic;



public class Palabra {
	
	private int codigo;
	private char letra;
	private String  definicion;
	private int cantUsos;
	private int cantidadRespondidaCorrectamente;
	private String palabra;	
	private String categoria;
	
	public Palabra(int codigo, char letra, String definicion, int cantUsos, int cantidadRespondidaCorrectamente,
			String palabra, String categoria) {
		super();
		this.codigo = codigo;
		this.letra = letra;
		this.definicion = definicion;
		this.cantUsos = cantUsos;
		this.cantidadRespondidaCorrectamente = cantidadRespondidaCorrectamente;
		this.palabra = palabra;
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	public int getCantUsos() {
		return cantUsos;
	}

	public void setCantUsos(int cantUsos) {
		this.cantUsos = cantUsos;
	}

	public int getCantidadRespondidaCorrectamente() {
		return cantidadRespondidaCorrectamente;
	}

	public void setCantidadRespondidaCorrectamente(int cantidadRespondidaCorrectamente) {
		this.cantidadRespondidaCorrectamente = cantidadRespondidaCorrectamente;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


}	
