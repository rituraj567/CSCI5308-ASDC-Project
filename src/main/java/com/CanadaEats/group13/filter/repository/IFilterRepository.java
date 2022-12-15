package com.CanadaEats.group13.filter.repository;

import java.util.List;

import com.CanadaEats.group13.filter.dto.FilterDto;

public interface IFilterRepository {
    List<FilterDto> getAllFilters();

    List<FilterDto> updateFilters(List<FilterDto> filterDtos);
}
