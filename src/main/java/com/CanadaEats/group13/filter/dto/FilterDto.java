package com.CanadaEats.group13.filter.dto;

public class FilterDto {
    public String filterName;
    public int isActive;

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public FilterDto() {
    }

    public FilterDto(String filterName, int isActive) {
        this.filterName = filterName;
        this.isActive = isActive;
    }
}
