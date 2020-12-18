 package com.example.demo.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.converter.PostConverter;
import com.example.demo.entity.Post;
import com.example.demo.model.PostModelo;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UsuarioRepository;



@Service("postService")
public class PostService {
	
	@Autowired
	@Qualifier("postRepository")
	private PostRepository postRepository;
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("postConveter")
	private PostConverter postConverter;
	
	private static final Log logger = LogFactory.getLog(PostService.class);
	
	public boolean crear(Post post) {
		logger.info("Creando todo okey");
		if (usuarioRepository.existsById(post.getAutor().getId())){
			try {
				post.setAutor(usuarioRepository.findById(post.getAutor().getId()));
				logger.info("----1------");
				post.fechaActual();
				logger.info("----2------");
				postRepository.save(post);
				logger.info("----3------");
				return true;
			} catch (Exception e) {
				return false;
			}	
		} else {
			return false;
		}
		
	}
	
	public boolean actualizar(Long id, Post post) {
		try {
			Post viejoPost = postRepository.findById(id);
			try {
				viejoPost.actualizarPost(post);
				postRepository.save(viejoPost);
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
			Post post = postRepository.findById(id);
			postRepository.delete(post);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	public List<PostModelo> obtener() {
		return postConverter.convertirLista(postRepository.findAll());
	}
	
	public List<PostModelo> obtenerNoPublicados() {
		return postConverter.convertirLista(postRepository.findByPublicado(false));
	}
	
	public List<PostModelo> obtenerPostTitulo(String titulo) {
		return postConverter.convertirLista(postRepository.findByTituloContaining(titulo));
	}
}
