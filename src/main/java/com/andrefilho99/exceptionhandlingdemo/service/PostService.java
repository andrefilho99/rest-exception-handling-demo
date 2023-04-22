package com.andrefilho99.exceptionhandlingdemo.service;

import com.andrefilho99.exceptionhandlingdemo.domain.Post;
import com.andrefilho99.exceptionhandlingdemo.exceptions.LongMessageException;
import com.andrefilho99.exceptionhandlingdemo.exceptions.PostNotFoundException;
import com.andrefilho99.exceptionhandlingdemo.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private static final int MAX_CHARACTERS = 144;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        
        return postRepository.findById(id).orElseThrow(
                () -> new PostNotFoundException(String.format("Post with id %d not found.", id))
        );
    }

    public Post create(Post post) {

        validate(post);
        post.setCreated(new Date());
        return postRepository.save(post);
    }

    public Post update(Long id, Post post) {

        validate(post);
        Post updatedPost = findById(id);
        updatedPost.setMessage(post.getMessage());
        return postRepository.save(updatedPost);
    }

    public void delete(Long id) {

        Post post = findById(id);
        postRepository.delete(post);
    }

    private void validate(Post post) {

        if (post.getMessage().length() > MAX_CHARACTERS)
            throw new LongMessageException(
                    String.format(
                            "Current message has %d characters. The limit is %d",
                            post.getMessage().length(),
                            MAX_CHARACTERS)
            );
    }
}
