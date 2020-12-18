package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.model.UsuarioModelo;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/v1/api/usuario")
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService")
	UsuarioService usuarioService;
	
	@PostMapping("/")
	public boolean agregarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.crear(usuario);
	}
	
	@PutMapping("/{id}")
	public boolean actualizarUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario) {
		return usuarioService.actualizar(id, usuario);
	}
	
	@GetMapping("/")
	public List<UsuarioModelo> mostrarUsuario() {
		return usuarioService.obtener();
	}
	
	@GetMapping("/ciudad/{city}")
	public List<UsuarioModelo> mostrarUsuarioCiudad(@PathVariable("city") String city) {
		if (city == null) {
			city = "resistencia";
		}else {
			city.toUpperCase();
		}
		return usuarioService.obtenerCiudad(city);
	}
	
	@DeleteMapping("/{id}")
	public boolean eliminarUsuario(@PathVariable("id") long id) {
		return usuarioService.borrar(id);
	}
	
	//@GetMapping("fecha/{fecha}")
	//public List<UsuarioModelo> mostrarUsuarioFecha(@PathVariable("fecha") Date date) {
	//	return usuarioService.obtenerFecha(date);
	//}

}
