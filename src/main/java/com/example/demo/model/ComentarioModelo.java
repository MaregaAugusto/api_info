package com.example.demo.model;

import java.sql.Date;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Post;
import com.example.demo.entity.Usuario;


public class ComentarioModelo {
	
	private Long id;
	private Usuario autor;
	private Post post;
	private Date fechaCreacion;
	private String comentario;
	
	public ComentarioModelo() {
	}
	
	public ComentarioModelo(Comentario comentario) {
		this.id = comentario.getId();
		this.autor = comentario.getAutor();
		this.post = comentario.getPost();
		this.fechaCreacion = comentario.getFechaCreacion();
		this.comentario = comentario.getComentario();
	}
	
	public ComentarioModelo(Long id, Usuario autor,Post post, Date fechaCreacion, String comentario) {
		this.id = id;
		this.autor = autor;
		this.post = post;
		this.fechaCreacion = fechaCreacion;
		this.comentario = comentario;
	}
	
	public Long getId() {
		return id;
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
