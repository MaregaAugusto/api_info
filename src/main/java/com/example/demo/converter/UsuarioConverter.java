package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Usuario;
import com.example.demo.model.UsuarioModelo;

@Component("usuarioConveter")
public class UsuarioConverter {
	
	public List<UsuarioModelo> convertirLista(List<Usuario> usuarios) {
		List<UsuarioModelo> usuarioModelos = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			usuarioModelos.add(new UsuarioModelo(usuario));
		}
		
		return usuarioModelos;	
	}
}
