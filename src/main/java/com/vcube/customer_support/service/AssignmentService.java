
package com.vcube.customer_support.service;

import java.util.List;

import com.vcube.customer_support.entity.TicketAssignment;
import com.vcube.customer_support.dto.AssignmentRequest;

public interface AssignmentService {

    TicketAssignment assignTicket(AssignmentRequest request);

    List<TicketAssignment> getAllAssignments();

    TicketAssignment getAssignmentById(Long id);

    List<TicketAssignment> getAssignmentsByAgent(Integer agentId);

    void updateAssignmentStatus(Long id, String status);
}
