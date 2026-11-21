package com.vcube.customer_support.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.customer_support.dto.DashboardResponse;
import com.vcube.customer_support.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/statistics")
    public DashboardResponse getStatistics() {
        return service.getDashboardStatistics();
    }
}

//GET    http://localhost:8080/api/dashboard/statistics