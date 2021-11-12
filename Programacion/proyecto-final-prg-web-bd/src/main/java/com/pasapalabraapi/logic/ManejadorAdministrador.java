package com.pasapalabraapi.logic;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pasapalabraapi.persistence.*;

public class ManejadorAdministrador {
	
	private ManejadorBD manejadorBD = new ManejadorBD();

	public Usuario createAdministrador(int ciA, int pinA, String nombre, String apellido,int ci, int pin) throws Exception {
	
		//	if (manejadorBD.validateAdmin(ciA,pinA)) {
				
				return manejadorBD.AddAdministrador(new Administrador(ci, pin, nombre, apellido));
		//	}

		}
		// Un usuario identificado como Administrador, puede crear Administradores nuevos.
		
	public void delAdministrador(int ci) throws SQLException {
		// hacer verificacion
		manejadorBD.delAdministrador(ci);
	}
	
	public ArrayList<Usuario> getAdministradores() {
		return manejadorBD.getAdministradores();
	}
	// Dado un usuario identificado como Administrador, y la ci de otro Administrador, lo elimina del sistema.

	
}

