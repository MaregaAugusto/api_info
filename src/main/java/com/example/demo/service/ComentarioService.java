package com.example.demo.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.converter.ComentarioConverter;
import com.example.demo.entity.Comentario;
import com.example.demo.model.ComentarioModelo;
import com.example.demo.repository.ComentarioRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UsuarioRepository;


@Service("comentarioService")
public class ComentarioService {

	@Autowired
	@Qualifier("comentarioRepository")
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	@Qualifier("postRepository")
	private PostRepository postRepository;
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("comentarioConverter")
	private ComentarioConverter comentarioConverter;
	
	private static final Log logger = LogFactory.getLog(PostService.class);
	
	public boolean crear(Comentario comentario) {
		logger.info("Creando todo okey");
		if (usuarioRepository.existsById(comentario.getAutor().getId()) && postRepository.existsById(comentario.getPost().getId())){
			logger.info("----1------");
			try {
				comentario.setAutor(usuarioRepository.findById(comentario.getAutor().getId()));
				logger.info("----2------");
				comentario.setPost(postRepository.findById(comentario.getPost().getId()));
				logger.info("----3------");
				comentario.fechaActual();
				logger.info("----4------");
				comentarioRepository.save(comentario);
				logger.info("----5------");
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}	
	}
	
	public boolean actualizar(Long id, Comentario comentario) {
		try {
			Comentario viejoComentario = comentarioRepository.findById(id);
			try {
				viejoComentario.actualizarComentario(comentario);
				comentarioRepository.save(viejoComentario);
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
			Comentario comentario = comentarioRepository.findById(id);
			comentarioRepository.delete(comentario);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	public List<ComentarioModelo> obtener() {
		return comentarioConverter.convertirLista(comentarioRepository.findAll());
	}
}
