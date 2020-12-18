package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Post;
import com.example.demo.model.PostModelo;

@Component("postConveter")
public class PostConverter {
	
	public List<PostModelo> convertirLista(List<Post> posts) {
		List<PostModelo> postModelos = new ArrayList<>();
		for (Post post : posts) {
			postModelos.add(new PostModelo(post));
		}
		
		return postModelos;	
	}
	
}
