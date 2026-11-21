package com.vcube.customer_support.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.customer_support.entity.TicketAssignment;

public interface TicketAssignmentRepository
        extends JpaRepository<TicketAssignment, Long> {
}