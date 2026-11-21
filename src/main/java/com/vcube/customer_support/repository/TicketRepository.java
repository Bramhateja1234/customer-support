package com.vcube.customer_support.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.customer_support.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    long countByStatusIgnoreCase(String status);
}