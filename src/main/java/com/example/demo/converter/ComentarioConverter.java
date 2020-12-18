package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Comentario;
import com.example.demo.model.ComentarioModelo;


@Component("comentarioConverter")
public class ComentarioConverter {
	public List<ComentarioModelo> convertirLista(List<Comentario> comentarios) {
		List<ComentarioModelo> comentarioModelos = new ArrayList<>();
		for (Comentario comentario : comentarios) {
			comentarioModelos.add(new ComentarioModelo(comentario));
		}
		
		return comentarioModelos;	
	}
}
