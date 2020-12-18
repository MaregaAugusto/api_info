package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.converter.UsuarioConverter;
import com.example.demo.entity.Usuario;
import com.example.demo.model.UsuarioModelo;
import com.example.demo.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService {
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConveter")
	private UsuarioConverter usuarioConverter;
	
	public boolean crear(Usuario usuario) {
		try {
			usuario.fechaActual();
			usuarioRepository.save(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	public boolean actualizar(Long id, Usuario usuario) {
		try {
			Usuario viejoUsuario = usuarioRepository.findById(id);
			try {
				viejoUsuario.actualizarUsuario(usuario);
				usuarioRepository.save(viejoUsuario);
				return true;
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean borrar(long id) {
		try {
			Usuario post = usuarioRepository.findById(id);
			usuarioRepository.delete(post);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	public List<UsuarioModelo> obtener() {
		return usuarioConverter.convertirLista(usuarioRepository.findAll());
	}
	
	public List<UsuarioModelo> obtenerCiudad(String ciudad) {
		return usuarioConverter.convertirLista(usuarioRepository.findByCiudad(ciudad));
	}
	
	//public List<UsuarioModelo> obtenerFecha(Date date) {
		//return usuarioConverter.convertirLista(usuarioRepository.findByStartFechaCreacionAfter(date));
	//}
}
