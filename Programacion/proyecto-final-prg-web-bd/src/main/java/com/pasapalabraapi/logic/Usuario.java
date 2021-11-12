package com.pasapalabraapi.logic;

public class Usuario {
	private int ci, pin;
	private String nombre, apellido;

	public Usuario(int ci, 
			String nombre, String apellido, int pin) {
		super();
		this.ci = ci;
		this.pin = pin;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
