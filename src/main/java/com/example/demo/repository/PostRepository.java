package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Post;


@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Serializable> {
	
	public abstract Post findByTitulo(String titulo);
	
	public abstract Post findById(Long id);
	
	public abstract List<Post> findByPublicado(Boolean publicado);
	
	public abstract List<Post> findByTituloContaining(String titulo);
	
}
