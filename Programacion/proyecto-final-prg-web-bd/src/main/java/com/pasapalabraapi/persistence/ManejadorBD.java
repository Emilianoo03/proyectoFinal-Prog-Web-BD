package com.pasapalabraapi.persistence;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.pasapalabraapi.logic.Administrador;
import com.pasapalabraapi.logic.Categoria;
import com.pasapalabraapi.logic.Jugador;
import com.pasapalabraapi.logic.Palabra;
import com.pasapalabraapi.logic.Usuario;

public class ManejadorBD {

/*
	public static boolean validateAdmin(int ciA, int pinA) throws Exception {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		Usuario admin = null;
		
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT ci, pin FROM administradores as adm join Usuarios as user on adm.ci = user.ci where user.pin = " + pinA + "and adm.ci = " + ciA;
			// String query2 = "SELECT * FROM administradores as a, usuarios u where u.ci = a.ci and u.pin = " + pinA + " and a.ci = " + ciA ;
			ResultSet rs = stmt.executeQuery(query);
			 
			while(rs.next()) {

				int ci = rs.getInt("ci");
				int pin = rs.getInt("pin");
				
				
						/// COONSULTAR A JUAN SOBRE ESTO 

					// https://www.it-swarm-es.com/es/sql/devolver-valor-booleano-en-sql-select-statement/1067124793/
				//int ciFound = rs.getInt("ci");
				//String nombreFound = rs.getString("name");
				//int pinFound = rs.getInt("pin");
				
			//	user = new Jugador(nombreFound, ciFound, pinFound);
			}	

		}catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
			throw new Exception(e.getMessage());
		}
		
		if(user == null) {
			throw new Exception("The username and / or password you entered does not match our records. Please check and try again.");
		}
		
		return user != null;
	}
	
	*/


	///////////////////////////////////////////////////// Administradores /////////////////////////////////////////////////////
	
	public Usuario AddAdministrador(Usuario admin) throws SQLException {      /////////////////////////////////////////////////////////////////////
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();

		Statement stmt = con.createStatement();
		
		String insert = "INSERT INTO usuario (ci, nombre, apellido, pin ) VALUES (" + admin.getCi() + ", '" +
		admin.getNombre() + "', '" + admin.getApellido() + "', " + admin.getPin() + ")";
		
		String insert2 = "INSERT INTO  administrador value (" + admin.getCi() + " )";
		
		try {
			stmt.executeUpdate(insert);
			stmt.executeUpdate(insert2);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		// Un usuario identificado como Administrador, puede crear Administradores nuevos.
		
		return admin;
	}

	
	
	public void delAdministrador(int ci) throws SQLException {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();

		Statement stmt = con.createStatement();

		String delete = "DELETE FROM administrador WHERE ci_Administrador=" + ci ;
		try {
			stmt.executeUpdate(delete);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}  
	
	}
	
	
	
	public ArrayList<Usuario> getAdministradores() {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		
		ArrayList<Usuario> admins = new ArrayList<Usuario>();
		
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM Administrador join Usuario on Administrador.ci_administrador = Usuario.ci";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int ci = rs.getInt("ci_administrador");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int pin = rs.getInt("pin");
				
				admins.add(new Administrador(ci, pin,nombre,apellido));
			}
			
			return admins;

		}catch (SQLException e) {
			System.out.println(e.getMessage());
			
			return admins;
		}
	}
	
	
	///////////////////////////////////////////////////// Administradores /////////////////////////////////////////////////////
	
	
	
	///////////////////////////////////////////////////// Palabra /////////////////////////////////////////////////////
	
	public Palabra createPalabra(Palabra palabra) throws SQLException {      /////////////////////////////////////////////////////////////////////
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		Statement stmt = con.createStatement();
		
		String insert = "INSERT INTO palabra (letra, definicion, empiezaPor) VALUES ()";
		
		try {
			
		stmt.executeUpdate(insert);
		/*
	 
	 	Dado una letra, una definición y un boolean que especifica si se empieza por la letra 
	 	o la contiene, se crea una nueva Palabra para utilizar en el juego.  
		El código debe generarse automáticamente y no puede ser único	 
	
			 */
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}	
		return palabra;
	}
	
		




	public void delPalabra(int codigo) throws SQLException {           ///////////////////
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();

		Statement stmt = con.createStatement();
		String delete = "DELETE FROM (Table Palabra) WHERE codigo = " + codigo ;

		try {
			stmt.executeUpdate(delete);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}  
		
	}




	public ArrayList<Palabra> obtenerPalabra() {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();

		ArrayList<Palabra> palabras = new ArrayList<Palabra>();
		
		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM Palabra LIMIT 25";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				char letraFound = rs.getString("letra").charAt(0);
				String definicionFound = rs.getString("definicion");
				int codigoFound = rs.getInt("codigo");
				int cantidadRespondidaCorrectamenteFound = rs.getInt("cantidadRespondidaCorrectamente");
				int cantUsosFound = rs.getInt("");
				String categoriaFound = rs.getString("");
				
				
			Palabra palabra = new Palabra(cantUsosFound, letraFound, categoriaFound, cantUsosFound, cantUsosFound, categoriaFound, categoriaFound);
			palabras.add(palabra);
			}
			return palabras;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return palabras;
	}
	///////////////////////////////////////////////////// Palabra /////////////////////////////////////////////////////

	/*

	Caso 1: El sistema devuelve un ArrayList con 25 palabras, 
	tal que la letra de cada palabra debe ser distinta a las demás. 

	El estado de uso de las palabras elegidas debe estar en false y 
	luego de seleccionarlas las pasamos a true. En caso de que no tengamos palabras en false, 
	marcamos todas en true y obtenemos las mismas de forma aleatoria.

 	*/

	public ArrayList<Palabra> obtenerPalabra(String categoriaP) {         //// VER BD Y ESTO
		// Dado un nombre de categoría, se devuelven palabras igual al Caso 1,  pero de la categoría antes mencionada.
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();

		ArrayList<Palabra> palabras = new ArrayList<Palabra>();
		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM Palabra join Categoria on Palabra.categoria_id = Categoria.categoria_id LIMIT 25 where letra != letra";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				char letraFound = rs.getString("letra").charAt(0);
				int codigoFound = rs.getInt("codigo_Palabra");
				String definicionFound = rs.getString("definicion");
				boolean empiezaPorFound = rs.getBoolean("empiezaPor");
				String nomCategoriaFound = rs.getString("nombre_Categoria");
				int cantUsosFound = rs.getInt("cant_Usos");
				int cantRespCorrectamente = rs.getInt("cant_resp_correctamente");
				
				Palabra palabra = new Palabra(cantRespCorrectamente, letraFound, nomCategoriaFound, cantRespCorrectamente, cantRespCorrectamente, nomCategoriaFound, nomCategoriaFound);
				palabras.add(palabra);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return palabras;
	}



	public ArrayList<Palabra> getPalabrasPorCategoria(String categoria) {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		
		ArrayList<Palabra> palabras = new ArrayList<Palabra>();
		
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM Palabra where categoria = " + categoria;
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int codigoRs = rs.getInt("palabra_codigo");
				char letraRs = rs.getString("letra").charAt(0);
				String definicionRs = rs.getString("definicion");
				int cantUsosRs = rs.getInt("cant_Usos");
				int cantidadRespondidaCorrectamenteRs = rs.getInt("cant_resp_correctamente");
				String palabraRs = rs.getString("palabra");
				String categoriaRs = rs.getString("categoria");
				
				palabras.add(new Palabra(codigoRs, letraRs,definicionRs,cantUsosRs,cantidadRespondidaCorrectamenteRs,palabraRs,categoriaRs));
			}
			
			return palabras;

		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return palabras;
	}

	
}
