
package com.vcube.customer_support.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vcube.customer_support.dto.AssignmentRequest;
import com.vcube.customer_support.entity.TicketAssignment;
import com.vcube.customer_support.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService service;

    public AssignmentController(AssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public TicketAssignment assignTicket(@RequestBody AssignmentRequest request) {
        return service.assignTicket(request);
    }

    @GetMapping
    public List<TicketAssignment> getAllAssignments() {
        return service.getAllAssignments();
    }

    @GetMapping("/{id}")
    public TicketAssignment getAssignmentById(@PathVariable Long id) {
        return service.getAssignmentById(id);
    }

    @GetMapping("/agent/{agentId}")
    public List<TicketAssignment> getAssignmentsByAgent(
            @PathVariable Integer agentId) {
        return service.getAssignmentsByAgent(agentId);
    }

    @PutMapping("/{id}/status")
    public String updateAssignmentStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        service.updateAssignmentStatus(id, status);

        return "Assignment status updated successfully";
    }
}

//POST  http://localhost:8080/api/assignments
//
//GET    http://localhost:8080/api/assignments
//
//GET    http://localhost:8080/api/assignments/1
//
//GET    http://localhost:8080/api/assignments/agent/2
//
//PUT    http://localhost:8080/api/assignments/1/status?status=COMPLETED