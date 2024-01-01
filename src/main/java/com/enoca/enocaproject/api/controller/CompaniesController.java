package com.enoca.enocaproject.api.controller;

import com.enoca.enocaproject.business.abstracts.CompanyService;
import com.enoca.enocaproject.business.abstracts.EmployeeService;
import com.enoca.enocaproject.business.dto.requests.create.CreateCompanyRequest;
import com.enoca.enocaproject.business.dto.requests.create.CreateEmployeeRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateCompanyRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateEmployeeRequest;
import com.enoca.enocaproject.business.dto.responses.create.CreateCompanyResponse;
import com.enoca.enocaproject.business.dto.responses.create.CreateEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllCompaniesResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllEmployeesResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetCompanyResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.update.UpdateCompanyResponse;
import com.enoca.enocaproject.business.dto.responses.update.UpdateEmployeeResponse;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.v3.core.util.Json;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/companies")
public class CompaniesController {
    private final CompanyService service;

    @GetMapping(value = "/getalljson",consumes = "application/json")
    public JSONArray getAllJson() {
        List<GetAllCompaniesResponse> companies = service.getAll();
        return new JSONArray(companies);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String jsonString = mapper.writeValueAsString(companies);
//           return new JSONArray(jsonString);
//            //return jsonString;
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

    }

    @GetMapping
    public String getAll(Model model) { //bu actionların her birinin birer view'ı var
        List<GetAllCompaniesResponse> companies = service.getAll();
        model.addAttribute("companies", companies); //requestbody
        return "companies-list";
    }

    @GetMapping("/add")
    public String add(Model model) {

        return "companies-add";
    }

    @GetMapping("/update/{companyId}")
    public String update(@PathVariable("companyId") int companyId, Model model) {
        var company = service.getById(companyId);
        model.addAttribute("company", company);
        return "companies-update";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("company") CreateCompanyRequest request, Model model) {
        service.add(request);
        return "redirect:/api/companies";
    }

    @PostMapping("/update/{companyId}")
    public String update(@PathVariable("companyId") int companyId,@ModelAttribute("company") UpdateCompanyRequest request,Model model) {
        service.update(companyId, request);
        return "redirect:/api/companies";
    }

    @GetMapping("/delete/{companyId}")
    public String delete(@PathVariable("companyId") int companyId) {
        service.delete(companyId);
        return "redirect:/api/companies";
    }
}
