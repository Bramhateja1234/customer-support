package com.vcube.customer_support.service.impl;

import org.springframework.stereotype.Service;

import com.vcube.customer_support.dto.DashboardResponse;
import com.vcube.customer_support.repository.CategoryRepository;
import com.vcube.customer_support.repository.TicketRepository;
import com.vcube.customer_support.repository.UserRepository;
import com.vcube.customer_support.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepo;
    private final TicketRepository ticketRepo;
    private final CategoryRepository categoryRepo;

    public DashboardServiceImpl(UserRepository userRepo,
            TicketRepository ticketRepo,
            CategoryRepository categoryRepo) {

        this.userRepo = userRepo;
        this.ticketRepo = ticketRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public DashboardResponse getDashboardStatistics() {

        long totalUsers = userRepo.count();

        long totalCustomers = userRepo.countByRoleIgnoreCase("CUSTOMER");

        long totalAgents = userRepo.countByRoleIgnoreCase("AGENT");

        long totalTickets = ticketRepo.count();

        long openTickets = ticketRepo.countByStatusIgnoreCase("OPEN");

        long inProgressTickets =
                ticketRepo.countByStatusIgnoreCase("IN_PROGRESS");

        long resolvedTickets =
                ticketRepo.countByStatusIgnoreCase("RESOLVED");

        long totalCategories = categoryRepo.count();

        return new DashboardResponse(
                totalUsers,
                totalCustomers,
                totalAgents,
                totalTickets,
                openTickets,
                inProgressTickets,
                resolvedTickets,
                totalCategories
        );
    }
}