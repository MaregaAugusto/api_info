package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "comentario")
@Entity
public class Comentario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Usuario autor;
	@OneToOne
	private Post post;
	private Date fechaCreacion;
	@Column(length = 200)
	private String comentario;
	
	public Comentario() {
	}

	public Comentario(Long id, Usuario autor,Post post, Date fechaCreacion, String comentario) {
		this.id = id;
		this.autor = autor;
		this.post = post;
		this.fechaCreacion = fechaCreacion;
		this.comentario = comentario;
	}
	
	public void actualizarComentario(Comentario comentario) {
		if (comentario.getComentario()!=null) {
			this.comentario = comentario.getComentario();
		}
	}
	
	public void fechaActual() {
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);  
        this.fechaCreacion = date; 
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getAutor() {
		return autor;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
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
