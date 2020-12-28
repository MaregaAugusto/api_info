package com.example.demo.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	
	public abstract Usuario findById(Long id);
	
	public abstract List<Usuario> findByCiudad(String ciudad);
	
	public abstract List<Usuario> findByFechaCreacion(LocalDate fechaCreacion);
	
	public abstract List<Usuario> findAllByFechaCreacionBetween(
			LocalDate fechaCreacion, LocalDate fechaActual);
	
}
