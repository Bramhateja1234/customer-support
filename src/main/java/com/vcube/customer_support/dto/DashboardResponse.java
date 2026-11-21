package com.vcube.customer_support.dto;

public class DashboardResponse {

    private long totalUsers;
    private long totalCustomers;
    private long totalAgents;
    private long totalTickets;
    private long openTickets;
    private long inProgressTickets;
    private long resolvedTickets;
    private long totalCategories;

    public DashboardResponse(long totalUsers, long totalCustomers,
            long totalAgents, long totalTickets, long openTickets,
            long inProgressTickets, long resolvedTickets,
            long totalCategories) {

        this.totalUsers = totalUsers;
        this.totalCustomers = totalCustomers;
        this.totalAgents = totalAgents;
        this.totalTickets = totalTickets;
        this.openTickets = openTickets;
        this.inProgressTickets = inProgressTickets;
        this.resolvedTickets = resolvedTickets;
        this.totalCategories = totalCategories;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public long getTotalCustomers() {
        return totalCustomers;
    }

    public long getTotalAgents() {
        return totalAgents;
    }

    public long getTotalTickets() {
        return totalTickets;
    }

    public long getOpenTickets() {
        return openTickets;
    }

    public long getInProgressTickets() {
        return inProgressTickets;
    }

    public long getResolvedTickets() {
        return resolvedTickets;
    }

    public long getTotalCategories() {
        return totalCategories;
    }
}