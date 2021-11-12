package com.pasapalabraapi.logic;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pasapalabraapi.persistence.ManejadorBD;


public class ManejadorPalabras {
	
	private ManejadorBD manejadorBD = new ManejadorBD();
	
	public Palabra createPalabra(char letra, String definicion, int codigo, int cantidadRespondidaCorrectamente, int cantUsos, String palabra,String categoria) throws SQLException {
			
			return manejadorBD.createPalabra(new Palabra(codigo,letra,definicion,cantUsos,cantidadRespondidaCorrectamente,palabra,categoria));

	}
				/* Dado una letra, una definición y un boolean que especifica 
					si se empieza por la letra o la contiene,
					 se crea una nueva Palabra para utilizar en el juego.
					El código debe generarse automáticamente y no puede ser único.
				*/
	
	public void elimiarPalabra(int codigo) throws SQLException {  /////////////////// /////////////////// ///////////////////
		manejadorBD.delPalabra(codigo);	
	}
	
	/* Dado un código de palabra, se elimina de la aplicación.   */
	
	public ArrayList<Palabra> obtenerPalabra() {
		return manejadorBD.obtenerPalabra();
	}
	
	/*

		Caso 1: El sistema devuelve un ArrayList con 25 palabras, 
		tal que la letra de cada palabra debe ser distinta a las demás. 

		El estado de uso de las palabras elegidas debe estar en false y 
		luego de seleccionarlas las pasamos a true. En caso de que no tengamos palabras en false, 
		marcamos todas en true y obtenemos las mismas de forma aleatoria.

	 */
	
	
	public ArrayList<Palabra> obtenerPalabra(String categoria) {
		return manejadorBD.obtenerPalabra(categoria);
	}

	/*
	Caso 2: Dado un nombre de categoría, se devuelven palabras igual al Caso 1, 
	pero de la categoría antes mencionada.

	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
