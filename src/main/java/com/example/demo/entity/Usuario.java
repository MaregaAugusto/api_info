package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name="usuario")
@Entity
public class Usuario implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nombre;
	private String apellido;
	@Column(unique = true)
	private String email;
	private String password;
    private Date fechaCreacion;
	private String ciudad;
	private String provincia;
	private String pais;
	
	public Usuario() {
	}
	
	public void actualizarUsuario(Usuario usuario) {
		if (usuario.getNombre() != null) {
			this.nombre =usuario.getNombre();
		}
		if (usuario.getApellido() != null) {
			this.apellido = usuario.getApellido();
		}
		if (usuario.getEmail() != null) {
			this.email = usuario.getEmail();
		}
		if (usuario.getPassword() != null) {
			this.password = usuario.getPassword();
		}
		if (usuario.getFechaCreacion() != null) {
			this.fechaCreacion = usuario.getFechaCreacion();
		}
		if (usuario.getCiudad() != null) {
			this.ciudad = usuario.getCiudad();
		}
		if (usuario.getProvincia() != null) {
			this.provincia = usuario.getProvincia();
		}
		if (usuario.getPais() != null) {
			this.pais = usuario.getPais();
		}
	}

	public Usuario(Long id, String nombre, String apellido, String email, String password,
			Date fechaCreacion ,String ciudad, String provincia, String pais) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.fechaCreacion =  fechaCreacion;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
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
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
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
