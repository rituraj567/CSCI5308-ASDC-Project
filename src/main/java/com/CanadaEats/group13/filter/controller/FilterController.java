package com.CanadaEats.group13.filter.controller;

import com.CanadaEats.group13.filter.business.FilterBusiness;
import com.CanadaEats.group13.filter.dto.FilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class FilterController {

    @Autowired
    FilterBusiness filterBusiness;

    @GetMapping("/filters")
    public String getAllFilters(Model model) {
        List<FilterDto> filters = filterBusiness.getAllFilters();
        model.addAttribute("filters", filters);
        return "/filter/displayFilters";
    }

    @PostMapping("/updatefilters")
    public String updateFilters(@ModelAttribute List<FilterDto> filterDto,Model model){
        System.out.println("Request has reached");
        List<FilterDto> filters = filterBusiness.updateFilters(filterDto);
        return "redirect:/filters";
    }
}
