package com.CanadaEats.group13.filter.business;

import java.util.List;

import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.filter.repository.IFilterRepository;

public class FilterBusiness implements IFilterBusiness {

    IFilterRepository filterRepository;

    public FilterBusiness(IFilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    @Override
    public List<FilterDto> getAllFilters() {
        List<FilterDto> response = filterRepository.getAllFilters();
        return response;
    }

    public List<FilterDto> updateFilters(List<FilterDto> filterDtos) {
        List<FilterDto> filters = filterRepository.updateFilters(filterDtos);
        return filters;
    }
}
