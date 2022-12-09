package com.CanadaEats.group13.filter.repository;

import com.CanadaEats.group13.filter.dto.FilterDto;

import java.util.List;

public interface IFilterRepository {
    List<FilterDto> getAllFilters();
    List<FilterDto> updateFilters(List<FilterDto> filterDtos);
}
