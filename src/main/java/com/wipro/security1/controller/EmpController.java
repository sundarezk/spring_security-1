package com.wipro.security1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmpController {

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String getAllEmployees(Authentication authentication) {

        return "User : " + authentication.getName()
                + " | Roles : " + authentication.getAuthorities()
                + " | You Received All Employees List";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String saveEmployees() {

        return "You saved an employee";
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String updateEmployees() {

        return "You updated an employee";
    }
}
