package com.example.demo.model;

import java.sql.Date;

import com.example.demo.entity.Post;
import com.example.demo.entity.Usuario;

public class PostModelo {
	private Long id;
	private String titulo;
	private String descripcion;
	private String contenido;
	private Date fechaCreacion;
	private Usuario autor;
	private Boolean publicado;
	
	public PostModelo() {};
	
	public PostModelo(Post post) {
		this.id = post.getId();
		this.titulo = post.getTitulo();
		this.descripcion = post.getDescripcion();
		this.contenido = post.getContenido();
		this.fechaCreacion = post.getFechaCreacion();
		this.autor = post.getAutor();
		this.publicado = post.getPublicado();
	};
	
	public PostModelo(Long id, String titulo, String descripcion, String contenido, Date fechaCreacion, Usuario autor,
			Boolean publicado) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.fechaCreacion = fechaCreacion;
		this.autor = autor;
		this.publicado = publicado;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public Boolean getPublicado() {
		return publicado;
	}
	public void setPublicado(Boolean publicado) {
		this.publicado = publicado;
	}
	
	
}
