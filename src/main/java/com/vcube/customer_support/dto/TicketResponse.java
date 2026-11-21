
package com.vcube.customer_support.dto;

public class TicketResponse {

    private Long ticketId;
    private Integer customerId;
    private Integer categoryId;
    private String subject;
    private String description;
    private String priority;
    private String status;

    public TicketResponse(Long ticketId, Integer customerId,
            Integer categoryId, String subject, String description,
            String priority, String status) {

        this.ticketId = ticketId;
        this.customerId = customerId;
        this.categoryId = categoryId;
        this.subject = subject;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }
}
