package com.javacodes.springboot.controlles;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javacodes.springboot.model.Post;
import com.javacodes.springboot.repos.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
	public Page<Post> getAllPosts(Pageable pageable){
		return postRepository.findAll(pageable);
	
	}
	@PostMapping("/posts")
    public Post createPost(@Valid @RequestBody Post post) {
    	
		return postRepository.save(post);
    	
    }
	@PutMapping("/posts/{postId}")
	public Post updatePost(@PathVariable Long postId, @RequestBody Post postRequest) {
		return postRepository.findById(postId).map(post ->{
			post.setTitle(postRequest.getTitle());
			post.setDescription(postRequest.getDescription());
			post.setContent(postRequest.getContent());
			
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("postId" + postId + "Not found"));
		
	}
	
	public ResponseEntity<?> deletePost(@PathVariable Long postId){
		return postRepository.findById(postId).map(post ->{
			
			postRepository.delete(post);
			
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PostId" + postId + "not found"));
		
	}

}