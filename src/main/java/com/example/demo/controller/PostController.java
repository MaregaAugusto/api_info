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

import com.example.demo.entity.Post;
import com.example.demo.model.PostModelo;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/v1/api/post")
public class PostController {
	
	@Autowired
	@Qualifier("postService")
	PostService postService;

	@PostMapping("/")
	public boolean agregarPost(@RequestBody Post post) {
		return postService.crear(post);
	}
	
	@PutMapping("/{id}")
	public boolean actualizarPost(@PathVariable("id") long id, @RequestBody Post post) {
		return postService.actualizar(id, post);
	}
	
	@GetMapping("/")
	public List<PostModelo> mostrarPost() {
		return postService.obtener();
	}
	
	@GetMapping("/NoPublicado")
	public List<PostModelo> mostrarPostNoPublicados() {
		return postService.obtenerNoPublicados();
	}
	
	@GetMapping("/Titulo/{titulo}")
	public List<PostModelo> mostrarPostTitulo(@PathVariable("titulo") String titulo) {
		return postService.obtenerPostTitulo(titulo);
	}
	
	@DeleteMapping("/{id}")
	public boolean eliminarPost(@PathVariable("id") long id) {
		return postService.borrar(id);
	}
	
}
