package com.andrefilho99.exceptionhandlingdemo.controller;

import com.andrefilho99.exceptionhandlingdemo.domain.Post;
import com.andrefilho99.exceptionhandlingdemo.dto.PostRequest;
import com.andrefilho99.exceptionhandlingdemo.dto.PostResponse;
import com.andrefilho99.exceptionhandlingdemo.service.PostService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {

        List<Post> posts = postService.findAll();
        List<PostResponse> postResponses = posts
                .stream()
                .map(post -> modelMapper.map(post, PostResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(postResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findById(@PathVariable Long id) {

        Post post = postService.findById(id);
        PostResponse postResponse = modelMapper.map(post, PostResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(postResponse);
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest postRequest) {

        Post post = postService.create(modelMapper.map(postRequest, Post.class));
        PostResponse postResponse = modelMapper.map(post, PostResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(postResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> update(@PathVariable Long id, @RequestBody PostRequest postRequest) {

        Post post = postService.update(id, modelMapper.map(postRequest, Post.class));
        PostResponse postResponse = modelMapper.map(post, PostResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
