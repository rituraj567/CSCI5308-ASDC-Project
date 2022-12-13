package com.CanadaEats.group13.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.filter.dto.FilterDto;

public class FilterDtoTest {
    FilterDto filterDto;

    @BeforeEach
    public void testSetup() {
        filterDto = new FilterDto("filter1", 1);
    }

    @Test
    public void getFilterNameTest() {
        assertEquals("filter1", filterDto.getFilterName());
    }

    @Test
    public void getIsActiveTest() {
        assertEquals(1, filterDto.getIsActive());
    }

    @Test
    public void setFilterNameTest() {
        String newValue = "filter1";
        filterDto.setFilterName(newValue);
        assertEquals(newValue, filterDto.getFilterName());
    }

    @Test
    public void setIsActiveTest() {
        int newValue = 1;
        filterDto.setIsActive(newValue);
        assertEquals(newValue, filterDto.getIsActive());
    }
}
