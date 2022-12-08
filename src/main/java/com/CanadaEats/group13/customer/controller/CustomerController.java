package com.CanadaEats.group13.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CustomerController {
    @GetMapping("/userHomePage")
    public String displayHomePage(@ModelAttribute("customer") Model model) {
        model.addAttribute("customer", model.getAttribute("customer"));

        return "customer/customerHomePage";
    }
}
