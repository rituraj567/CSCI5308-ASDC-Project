package com.CanadaEats.group13.filter.controller;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.filter.business.FilterBusiness;
import com.CanadaEats.group13.filter.business.IFilterBusiness;
import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.filter.repository.FilterRepository;
import com.CanadaEats.group13.utils.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class FilterController {

    IFilterBusiness filterBusiness;

    public FilterController(){
        this.filterBusiness = new FilterBusiness(new FilterRepository(DatabaseConnection.getInstance()));
    }

    @GetMapping("/filters")
    public String getAllFilters(Model model, HttpServletRequest request) {
        List<FilterDto> filters = filterBusiness.getAllFilters();
        model.addAttribute("filters", filters);
        return "/filter/displayFilters";
    }

    @PostMapping("/updatefilters")
    public String updateFilters(@ModelAttribute List<FilterDto> filterDto,Model model){
        System.out.println("Request has reached");
        filterBusiness.updateFilters(filterDto);
        return "redirect:/filters";
    }
}
