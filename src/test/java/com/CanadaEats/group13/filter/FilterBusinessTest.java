package com.CanadaEats.group13.filter;

import com.CanadaEats.group13.filter.business.FilterBusiness;
import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.filter.repository.FilterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class FilterBusinessTest {
    @InjectMocks
    FilterBusiness filterBusiness;

    @Mock
    FilterRepository filterRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void getAllFilterSuccessTest(){
        List<FilterDto> filterResponse = prepareFilterData();
        when(filterRepository.getAllFilters()).thenReturn(filterResponse);

        List<FilterDto> result = filterBusiness.getAllFilters();

        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(filterResponse.get(0).getFilterName(), result.get(0).getFilterName());
    }

    @Test
    final void getAllFilterFailureTest(){
        List<FilterDto> filterResponse = prepareFilterData();
        when(filterRepository.getAllFilters()).thenReturn(filterResponse);

        List<FilterDto> result = filterBusiness.getAllFilters();

        assertNotNull(result);
        assertNotEquals(filterResponse.get(1).getIsActive(), result.get(2).getIsActive());
    }

    @Test
    final void updateFiltersSuccessTest(){
        List<FilterDto> filterResponse = prepareFilterData();
        when(filterRepository.updateFilters(any())).thenReturn(filterResponse);

        List<FilterDto> result = filterBusiness.updateFilters(filterResponse);

        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(filterResponse.get(0).getFilterName(), result.get(0).getFilterName());
    }

    @Test
    final void updateFiltersFailureTest(){
        List<FilterDto> filterResponse = prepareFilterData();
        when(filterRepository.updateFilters(any())).thenReturn(filterResponse);

        List<FilterDto> result = filterBusiness.updateFilters(filterResponse);

        assertNotNull(result);
        assertNotEquals(filterResponse.get(1).getIsActive(), result.get(2).getIsActive());
    }

    private List<FilterDto> prepareFilterData()
    {
        List<FilterDto> filterDtos = new ArrayList<>();

        FilterDto filter1 = new FilterDto();
        filter1.setFilterName("Price Low To High");
        filter1.setIsActive(1);
        filterDtos.add(filter1);

        FilterDto filter2 = new FilterDto();
        filter2.setFilterName("Price High To Low");
        filter2.setIsActive(1);
        filterDtos.add(filter2);

        FilterDto filter3 = new FilterDto();
        filter3.setFilterName("Ratings Low To High");
        filter3.setIsActive(0);
        filterDtos.add(filter3);

        FilterDto filter4 = new FilterDto();
        filter4.setFilterName("Ratings High To Low");
        filter4.setIsActive(1);
        filterDtos.add(filter4);

        return filterDtos;
    }
}
