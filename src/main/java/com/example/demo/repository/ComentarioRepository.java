package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Post;


@Repository("comentarioRepository")
public interface ComentarioRepository extends JpaRepository<Comentario, Serializable>, PagingAndSortingRepository<Comentario, Serializable>{

	public abstract Comentario findById(Long id);
	
	public abstract Page<Comentario> findByPost(Post post, Pageable pageable);
}
