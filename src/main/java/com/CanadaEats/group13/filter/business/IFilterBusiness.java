package com.CanadaEats.group13.filter.business;

import com.CanadaEats.group13.filter.dto.FilterDto;

import java.util.List;

public interface IFilterBusiness {
    List<FilterDto> getAllFilters();
    List<FilterDto> updateFilters(List<FilterDto> filterDtos);
}
