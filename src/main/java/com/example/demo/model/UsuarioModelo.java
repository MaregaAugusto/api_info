package com.example.demo.model;


import java.time.LocalDate;

import com.example.demo.entity.Usuario;

public class UsuarioModelo {

    private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fechaCreacion;
	private String ciudad;
	private String provincia;
	private String pais;
	
	public UsuarioModelo() {
	}
	
	public UsuarioModelo(Usuario usuario) {
		this.id = usuario.getId();
		this.nombre =usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.email = usuario.getEmail();
		this.fechaCreacion = usuario.getFechaCreacion();
		this.ciudad = usuario.getCiudad();
		this.provincia = usuario.getProvincia();
		this.pais = usuario.getPais();
	}
	
	public UsuarioModelo(Long id, String nombre, String apellido, String email, LocalDate fechaCreacion,
			String ciudad, String provincia, String pais) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
}
