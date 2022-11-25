package com.defaultid.myspringapp.controllers;

import com.defaultid.myspringapp.models.Post;
import com.defaultid.myspringapp.repositories.MessageRepository;
import com.defaultid.myspringapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MessageRepository messageRepository;


    @PostMapping("/create")
    public ResponseEntity createPost(@RequestBody Post post) {
        if (post.getMainMessage() == null) {
            return ResponseEntity.badRequest().body("Invalid Json");
        }
        if (post.getSubMessages() != null) {
            post.getSubMessages().forEach(message -> {
                messageRepository.save(message);
            });
        }
        messageRepository.save(post.getMainMessage());
        return ResponseEntity.ok(postRepository.save(post));
    }

//    @GetMapping("/{id}")
//    public Optional<Post> getPost(@PathVariable String id) {
//        return postRepository.findById(Long.valueOf(id));
//    }

}
