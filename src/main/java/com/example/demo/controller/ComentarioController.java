package com.example.demo.controller;

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

import com.example.demo.entity.Comentario;
import com.example.demo.model.ComentarioModelo;
import com.example.demo.service.ComentarioService;


@RestController
@RequestMapping("/v1/api/comentario")
public class ComentarioController {

	@Autowired
	@Qualifier("comentarioService")
	ComentarioService comentarioService;
	
	@PostMapping("/")
	public boolean agregarComentario(@RequestBody Comentario comentario) {
		return comentarioService.crear(comentario);
	}
	
	@PutMapping("/{id}")
	public boolean actualizarComentario(@PathVariable("id") long id, @RequestBody Comentario comentario) {
		return comentarioService.actualizar(id, comentario);
	}
	
	@GetMapping("/")
	public List<ComentarioModelo> mostrarComentario() {
		return comentarioService.obtener();
	}
	
	@DeleteMapping("/{id}")
	public boolean eliminarComentario(@PathVariable("id") long id) {
		return comentarioService.borrar(id);
	}
}
