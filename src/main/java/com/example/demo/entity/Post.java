package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name = "post")
@Entity
public class Post implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String titulo;
	private String descripcion;
	private String contenido;
	private Date fechaCreacion;
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario autor;
	private Boolean publicado;
	
	public Post() {	
	}
	
	public Post(Long id, String titulo, String descripcion, String contenido, Date fechaCreacion, Usuario autor,
			Boolean publicado) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.fechaCreacion = fechaCreacion;
		this.autor = autor;
		this.publicado = publicado;
	}
	
	public void actualizarPost(Post post) {
		if (post.getTitulo()!=null) {
			this.titulo = post.getTitulo();
		}
		if (post.getDescripcion()!=null) {
			this.descripcion = post.getDescripcion();
		}
		if (post.getContenido()!=null) {
			this.contenido = post.getContenido();
		}
		if (post.getPublicado()!=null) {
			this.publicado = post.getPublicado();
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
