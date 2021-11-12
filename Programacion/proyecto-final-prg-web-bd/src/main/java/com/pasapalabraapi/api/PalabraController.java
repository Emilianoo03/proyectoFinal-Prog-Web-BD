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

import com.pasapalabraapi.DTO.CreatePalabraDTO;
import com.pasapalabraapi.DTO.CreateUsuarioDTO;
import com.pasapalabraapi.DTO.DeletePalabraDTO;
import com.pasapalabraapi.logic.Palabra;
import com.pasapalabraapi.logic.Usuario;
import com.pasapalabraapi.persistence.ManejadorBD;

@Controller
public class PalabraController {
	
	ManejadorBD palMan = new ManejadorBD();
	
	@PostMapping("/palabras")
	@ResponseBody
	public Palabra createPalabra(@RequestBody CreatePalabraDTO request) {
		Palabra palabras = null;
		try {
			
			palabras = this.palMan.createPalabra();
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		return palabras;
	}
	
	@DeleteMapping("/palabras")
	@ResponseBody
	public void deletePalabra(@RequestBody DeletePalabraDTO palabra) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not implemented...");
	}

	@GetMapping("/palabras")
	@ResponseBody
	public ArrayList<Palabra> getPalabrasPorCategoria(@RequestParam(name="categoria", required=false, defaultValue="categoria") String categoria) {
		try {
			return this.palMan.getPalabrasPorCategoria(categoria);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not implemented...");
		}
	}  
}
