package com.vcube.customer_support.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vcube.customer_support.dto.CommentRequest;
import com.vcube.customer_support.dto.CommentResponse;
import com.vcube.customer_support.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping
    public CommentResponse addComment(@RequestBody CommentRequest request) {
        return service.addComment(request);
    }

    @GetMapping("/ticket/{ticketId}")
    public List<CommentResponse> getCommentsByTicket(
            @PathVariable Long ticketId) {
        return service.getCommentsByTicket(ticketId);
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long id) {
        service.deleteComment(id);
        return "Comment deleted successfully";
    }
}

//POST   http://localhost:8080/api/comments
//
//GET    http://localhost:8080/api/comments/ticket/1
//
//DELETE http://localhost:8080/api/comments/1