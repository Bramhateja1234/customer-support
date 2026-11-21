
package com.vcube.customer_support.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.customer_support.dto.TicketRequest;
import com.vcube.customer_support.dto.TicketResponse;
import com.vcube.customer_support.entity.Ticket;
import com.vcube.customer_support.entity.User;
import com.vcube.customer_support.entity.Category;
import com.vcube.customer_support.repository.TicketRepository;
import com.vcube.customer_support.repository.UserRepository;
import com.vcube.customer_support.repository.CategoryRepository;
import com.vcube.customer_support.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public TicketServiceImpl(
            TicketRepository ticketRepository,
            UserRepository userRepository,
            CategoryRepository categoryRepository) {

        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    private TicketResponse convertToResponse(Ticket ticket) {

        return new TicketResponse(
                ticket.getTicketId(),
                ticket.getCustomer().getUserId(),
                ticket.getCategory().getCategoryId(),
                ticket.getSubject(),
                ticket.getDescription(),
                ticket.getPriority(),
                ticket.getStatus()
        );
    }

    @Override
    public TicketResponse createTicket(TicketRequest request) {

        User customer = userRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Ticket ticket = new Ticket();

        ticket.setCustomer(customer);
        ticket.setCategory(category);
        ticket.setSubject(request.getSubject());
        ticket.setDescription(request.getDescription());
        ticket.setPriority(request.getPriority());
        ticket.setStatus("OPEN");

        Ticket savedTicket = ticketRepository.save(ticket);

        return convertToResponse(savedTicket);
    }

    @Override
    public List<TicketResponse> getAllTickets() {

        return ticketRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public TicketResponse getTicketById(Long id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        return convertToResponse(ticket);
    }

    @Override
    public List<TicketResponse> getTicketsByCustomer(Integer customerId) {

        return ticketRepository.findAll()
                .stream()
                .filter(ticket -> ticket.getCustomer().getUserId().equals(customerId))
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public TicketResponse updateTicketStatus(Long id, String status) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setStatus(status);

        Ticket updatedTicket = ticketRepository.save(ticket);

        return convertToResponse(updatedTicket);
    }

    @Override
    public void deleteTicket(Long id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticketRepository.delete(ticket);
    }
}
