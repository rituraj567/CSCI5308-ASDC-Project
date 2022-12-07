package com.CanadaEats.group13.filter.business;

import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.filter.repository.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterBusiness implements IFilterBusiness{

    @Autowired
    FilterRepository filterRepository;

    @Override
    public List<FilterDto> getAllFilters() {
        List<FilterDto> response = filterRepository.getAllFilters();
        return response;
    }

    public List<FilterDto> updateFilters(List<FilterDto> filterDtos){
        List<FilterDto> filters = filterRepository.updateFilters(filterDtos);
        return filters;
    }
}
