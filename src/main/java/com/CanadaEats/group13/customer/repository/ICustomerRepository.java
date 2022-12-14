package com.CanadaEats.group13.customer.repository;

import com.CanadaEats.group13.customer.dto.RatingDto;

public interface ICustomerRepository {
    void addFeedBack(RatingDto ratingDto);
}
