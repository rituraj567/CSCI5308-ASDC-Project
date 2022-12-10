package com.CanadaEats.group13.customer.business;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.customer.repository.ICustomerRespository;

public class CustomerBusinness implements ICustomerBusiness {

    ICustomerRespository repository;

    public CustomerBusinness(ICustomerRespository repository) {
        this.repository = repository;
    }

  

}
