package com.pasapalabraapi.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.pasapalabraapi.DTO.CreateUsuarioDTO;
import com.pasapalabraapi.logic.ManejadorAdministrador;
import com.pasapalabraapi.logic.Usuario;

@Controller
public class AdminController {
	private ManejadorAdministrador admMan = new ManejadorAdministrador();
	
	@PostMapping("/admins")
	@ResponseBody
	public Usuario postAdministrador(@RequestBody(required=true) CreateUsuarioDTO request) {
		Usuario user = null;
		try {
			
			user = this.admMan.createAdministrador(request.getCi(), request.getPin(), request.getUser().getNombre(),request.getUser().getApellido(),request.getUser().getCi(),request.getUser().getPin());
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		return user;
	}	

	@GetMapping("/admins")
	@ResponseBody
	public ArrayList<Usuario> getAdministradores() {
		try {
			return this.admMan.getAdministradores();			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	

	 @DeleteMapping(value = "/admins")
	@ResponseBody
	public void delAdministradores(@RequestParam(name="ci", required=true) int ci) {
		try {
			this.admMan.delAdministrador(ci);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}  
	
	 
}
