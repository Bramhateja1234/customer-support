
package com.vcube.customer_support.service;

import java.util.List;

import com.vcube.customer_support.dto.TicketRequest;
import com.vcube.customer_support.dto.TicketResponse;

public interface TicketService {

    TicketResponse createTicket(TicketRequest request);

    List<TicketResponse> getAllTickets();

    TicketResponse getTicketById(Long id);

    List<TicketResponse> getTicketsByCustomer(Integer customerId);

    TicketResponse updateTicketStatus(Long id, String status);

    void deleteTicket(Long id);
}
