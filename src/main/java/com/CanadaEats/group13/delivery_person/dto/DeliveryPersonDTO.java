package com.CanadaEats.group13.delivery_person.dto;


import com.CanadaEats.group13.authentication.dto.UserDetailsDto;

public class DeliveryPersonDTO extends UserDetailsDto {

    private String RoleId="5941532b-da1d-427a-85d0-18cb44bd2932";

    @Override
    public String getRoleId() {
        return RoleId;
    }

}

