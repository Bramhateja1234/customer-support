
package com.vcube.customer_support.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.customer_support.dto.AssignmentRequest;
import com.vcube.customer_support.entity.Ticket;
import com.vcube.customer_support.entity.TicketAssignment;
import com.vcube.customer_support.entity.User;
import com.vcube.customer_support.repository.TicketAssignmentRepository;
import com.vcube.customer_support.repository.TicketRepository;
import com.vcube.customer_support.repository.UserRepository;
import com.vcube.customer_support.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final TicketAssignmentRepository assignmentRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public AssignmentServiceImpl(
            TicketAssignmentRepository assignmentRepository,
            TicketRepository ticketRepository,
            UserRepository userRepository) {

        this.assignmentRepository = assignmentRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TicketAssignment assignTicket(AssignmentRequest request) {

        Ticket ticket = ticketRepository.findById(request.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        User agent = userRepository.findById(request.getAgentId())
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        User admin = userRepository.findById(request.getAssignedBy())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        TicketAssignment assignment = new TicketAssignment();

        assignment.setTicket(ticket);
        assignment.setAgent(agent);
        assignment.setAssignedBy(admin);
        assignment.setAssignmentStatus("ASSIGNED");

        return assignmentRepository.save(assignment);
    }

    @Override
    public List<TicketAssignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public TicketAssignment getAssignmentById(Long id) {

        return assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    @Override
    public List<TicketAssignment> getAssignmentsByAgent(Integer agentId) {

        return assignmentRepository.findAll()
                .stream()
                .filter(a -> a.getAgent().getUserId().equals(agentId))
                .toList();
    }

    @Override
    public void updateAssignmentStatus(Long id, String status) {

        TicketAssignment assignment = getAssignmentById(id);

        assignment.setAssignmentStatus(status);

        assignmentRepository.save(assignment);
    }
}
