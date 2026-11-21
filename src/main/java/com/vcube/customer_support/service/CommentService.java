package com.vcube.customer_support.service;

import java.util.List;

import com.vcube.customer_support.dto.CommentRequest;
import com.vcube.customer_support.dto.CommentResponse;

public interface CommentService {

    CommentResponse addComment(CommentRequest request);

    List<CommentResponse> getCommentsByTicket(Long ticketId);

    void deleteComment(Long id);
}