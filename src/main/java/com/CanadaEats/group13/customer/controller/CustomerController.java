package com.CanadaEats.group13.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CanadaEats.group13.authentication.business.CookiesLogic;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.customer.business.CustomerBusinness;
import com.CanadaEats.group13.customer.business.ICustomerBusiness;
import com.CanadaEats.group13.customer.repository.CustomerRepository;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.utils.ApplicationConstants;

@Controller
public class CustomerController {

    ICustomerBusiness customerBusiness;

    public CustomerController() {
        this.customerBusiness = new CustomerBusinness(new CustomerRepository(DatabaseConnection.getInstance()));
    }

    @GetMapping("/userHomePage")
    public String displayHomePage(Model model, HttpServletRequest request) {
        

        return "customer/customerHomePage";

    }
}
