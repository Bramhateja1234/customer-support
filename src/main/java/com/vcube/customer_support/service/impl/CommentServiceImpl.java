package com.vcube.customer_support.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.customer_support.dto.CommentRequest;
import com.vcube.customer_support.dto.CommentResponse;
import com.vcube.customer_support.entity.Ticket;
import com.vcube.customer_support.entity.TicketComment;
import com.vcube.customer_support.entity.User;
import com.vcube.customer_support.repository.TicketCommentRepository;
import com.vcube.customer_support.repository.TicketRepository;
import com.vcube.customer_support.repository.UserRepository;
import com.vcube.customer_support.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    private final TicketCommentRepository commentRepo;
    private final TicketRepository ticketRepo;
    private final UserRepository userRepo;

    public CommentServiceImpl(
            TicketCommentRepository commentRepo,
            TicketRepository ticketRepo,
            UserRepository userRepo) {

        this.commentRepo = commentRepo;
        this.ticketRepo = ticketRepo;
        this.userRepo = userRepo;
    }

    @Override
    public CommentResponse addComment(CommentRequest request) {

        Ticket ticket = ticketRepo.findById(request.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TicketComment comment = new TicketComment();

        comment.setTicket(ticket);
        comment.setUser(user);
        comment.setComment(request.getComment());
        comment.setCommentType(request.getCommentType());
        comment.setRating(request.getRating());

        TicketComment saved = commentRepo.save(comment);

        return convertToResponse(saved);
    }

    @Override
    public List<CommentResponse> getCommentsByTicket(Long ticketId) {

        return commentRepo.findByTicket_TicketId(ticketId)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public void deleteComment(Long id) {

        TicketComment comment = commentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        commentRepo.delete(comment);
    }

    private CommentResponse convertToResponse(TicketComment comment) {

        return new CommentResponse(
                comment.getCommentId(),
                comment.getTicket().getTicketId(),
                comment.getUser().getUserId(),
                comment.getComment(),
                comment.getCommentType(),
                comment.getRating()
        );
    }
}