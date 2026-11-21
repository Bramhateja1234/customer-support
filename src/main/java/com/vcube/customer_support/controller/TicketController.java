
package com.vcube.customer_support.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vcube.customer_support.dto.TicketRequest;
import com.vcube.customer_support.dto.TicketResponse;
import com.vcube.customer_support.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public TicketResponse createTicket(@RequestBody TicketRequest request) {
        return service.createTicket(request);
    }

    @GetMapping
    public List<TicketResponse> getAllTickets() {
        return service.getAllTickets();
    }

    @GetMapping("/{id}")
    public TicketResponse getTicketById(@PathVariable Long id) {
        return service.getTicketById(id);
    }

    @GetMapping("/user/{customerId}")
    public List<TicketResponse> getTicketsByCustomer(
            @PathVariable Integer customerId) {
        return service.getTicketsByCustomer(customerId);
    }

    @PutMapping("/{id}/status")
    public TicketResponse updateTicketStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateTicketStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {
        service.deleteTicket(id);
        return "Ticket deleted successfully";
    }
}
//
//POST   http://localhost:8080/api/tickets
//
//GET    http://localhost:8080/api/tickets
//
//GET    http://localhost:8080/api/tickets/1
//
//GET    http://localhost:8080/api/tickets/user/1
//
//PUT    http://localhost:8080/api/tickets/1/status?status=RESOLVED
//
//DELETE http://localhost:8080/api/tickets/1