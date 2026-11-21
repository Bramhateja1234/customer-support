package com.vcube.customer_support.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.customer_support.entity.TicketComment;

public interface TicketCommentRepository
        extends JpaRepository<TicketComment, Long> {

    List<TicketComment> findByTicket_TicketId(Long ticketId);
}