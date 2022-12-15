package com.CanadaEats.group13.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.CanadaEats.group13.common.DTOFactory;
import com.CanadaEats.group13.filter.business.FilterBusiness;
import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.filter.repository.FilterRepository;

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
    final void getAllFilterSuccessTest() {
        List<FilterDto> filterResponse = prepareFilterData();
        when(filterRepository.getAllFilters()).thenReturn(filterResponse);

        List<FilterDto> result = filterBusiness.getAllFilters();

        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(filterResponse.get(0).getFilterName(), result.get(0).getFilterName());
    }

    @Test
    final void getAllFilterFailureTest() {
        List<FilterDto> filterResponse = prepareFilterData();
        when(filterRepository.getAllFilters()).thenReturn(filterResponse);

        List<FilterDto> result = filterBusiness.getAllFilters();

        assertNotNull(result);
        assertNotEquals(filterResponse.get(1).getIsActive(), result.get(2).getIsActive());
    }

    @Test
    final void updateFiltersSuccessTest() {
        List<FilterDto> filterResponse = prepareFilterData();
        when(filterRepository.updateFilters(any())).thenReturn(filterResponse);

        List<FilterDto> result = filterBusiness.updateFilters(filterResponse);

        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(filterResponse.get(0).getFilterName(), result.get(0).getFilterName());
    }

    @Test
    final void updateFiltersFailureTest() {
        List<FilterDto> filterResponse = prepareFilterData();
        when(filterRepository.updateFilters(any())).thenReturn(filterResponse);

        List<FilterDto> result = filterBusiness.updateFilters(filterResponse);

        assertNotNull(result);
        assertNotEquals(filterResponse.get(1).getIsActive(), result.get(2).getIsActive());
    }

    private List<FilterDto> prepareFilterData() {
        List<FilterDto> filterDtos = new ArrayList<>();

        FilterDto filter1 = DTOFactory.getInstance().createFiltersDto();
        filter1.setFilterName("Price Low To High");
        filter1.setIsActive(1);
        filterDtos.add(filter1);

        FilterDto filter2 = DTOFactory.getInstance().createFiltersDto();
        filter2.setFilterName("Price High To Low");
        filter2.setIsActive(1);
        filterDtos.add(filter2);

        FilterDto filter3 = DTOFactory.getInstance().createFiltersDto();
        filter3.setFilterName("Ratings Low To High");
        filter3.setIsActive(0);
        filterDtos.add(filter3);

        FilterDto filter4 = DTOFactory.getInstance().createFiltersDto();
        filter4.setFilterName("Ratings High To Low");
        filter4.setIsActive(1);
        filterDtos.add(filter4);

        return filterDtos;
    }
}
