package com.pasapalabraapi.logic;

import java.util.ArrayList;

import com.pasapalabraapi.persistence.ManejadorBD;

public class ManejadorPartidas {

	private ManejadorBD manejadorBD = new ManejadorBD();
	
	public Partida nuevaPartida(String nickname,int pin) {
		return null;

	}
	
	
	/*
	 	Dado un nickname y un pin (opcionalmente puede solicitar una categoría)

Caso 1: el nickname no existe. En este caso el sistema crea el usuario con el pin dado, luego continúa con el default.

Caso 2: el nickname existe y el pin es incorrecto. Devuelve un mensaje de error con el pin incorrecto.

Caso 3: el nickname existe y el pin es correcto. Salta al caso default.

Default: El sistema crea y devuelve una partida con 25 palabras (que pueden ser sobre una categoría o aleatorias) con un código de Partida único. 


	 * */
	
	public Partida nuevaPartida(String nickname,int pin,String categoria) {
		
		return null;
	}
	
	
	
	public void finalizarPartida(int codigoPartida,int puntaje) {
		
	}
	
	public ArrayList<Jugador> obtenerTop10JugadoresPartidasGanadas(){
		
		return null;

	}
	

	public ArrayList<Jugador> obtenerTop10JugadoresPartidasPerdidas(){
		
		return null;

	}
	
	public ArrayList<Palabra> obtenerTop10PalabrasMasDificiles(){

		return null;

	}
		
	
}
