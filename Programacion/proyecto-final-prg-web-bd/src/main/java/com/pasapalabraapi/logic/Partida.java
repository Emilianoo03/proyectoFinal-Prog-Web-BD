package com.pasapalabraapi.logic;


public class Partida {
	private int codigo;
	private String nickname;
	private boolean finalizada;
	private int puntaje;
	
	Palabra palabras[] = new Palabra[25];
	Jugador jugador;
	
	public Partida(int codigo, String nickname, boolean finalizada, int puntaje, Palabra[] palabras, Jugador jugador) {
		super();
		this.codigo = codigo;
		this.nickname = nickname;
		this.finalizada = finalizada;
		this.puntaje = puntaje;
		this.palabras = palabras;
		this.jugador = jugador;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public Palabra[] getPalabras() {
		return palabras;
	}

	public void setPalabras(Palabra[] palabras) {
		this.palabras = palabras;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	
	
}
