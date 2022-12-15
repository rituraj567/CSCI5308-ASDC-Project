package com.CanadaEats.group13.filter.business;

import java.util.List;

import com.CanadaEats.group13.filter.dto.FilterDto;

public interface IFilterBusiness {
    List<FilterDto> getAllFilters();

    List<FilterDto> updateFilters(List<FilterDto> filterDtos);
}
