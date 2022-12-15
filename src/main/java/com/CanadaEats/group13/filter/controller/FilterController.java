package com.CanadaEats.group13.filter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.filter.business.FilterBusiness;
import com.CanadaEats.group13.filter.business.IFilterBusiness;
import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.filter.repository.FilterRepository;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import com.CanadaEats.group13.utils.ApplicationConstants;

@Controller
public class FilterController {

    IFilterBusiness filterBusiness;

    public FilterController() {
        this.filterBusiness = new FilterBusiness(new FilterRepository(DatabaseConnection.getInstance()));
    }

    @GetMapping("/filters")
    public String getAllFilters(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            List<FilterDto> filters = filterBusiness.getAllFilters();
            model.addAttribute("filters", filters);
            return ApplicationConstants.URL_FILTER_DISPLAYFILTERS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @PostMapping("/updatefilters")
    public String updateFilters(@RequestBody List<FilterDto> filterDto, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            filterBusiness.updateFilters(filterDto);
            return ApplicationConstants.URL_FILTER_FILTERS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }
}
