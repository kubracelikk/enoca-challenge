package com.enoca.enocaproject.api.controller;

import com.enoca.enocaproject.business.abstracts.EmployeeService;
import com.enoca.enocaproject.business.dto.requests.create.CreateEmployeeRequest;
import com.enoca.enocaproject.business.dto.requests.create.CreateEmployeeRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateEmployeeRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateEmployeeRequest;
import com.enoca.enocaproject.business.dto.responses.create.CreateEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllCompaniesResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllEmployeesResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.update.UpdateEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeesController {
    private final EmployeeService service;


    @GetMapping
    public String getAll(Model model) {
        List<GetAllEmployeesResponse> employees = service.getAll();
        model.addAttribute("employee", employees);
        return "employees-list";
    }


    @GetMapping("/add")
    public String add(Model model) {

        return "employees-add";
    }

    @GetMapping("/update/{employeeId}")
    public String update(@PathVariable("employeeId") int employeeId, Model model) {
        var employee = service.getById(employeeId);
        model.addAttribute("employee", employee);
        return "employees-update";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("employee") CreateEmployeeRequest request, Model model) {
        service.add(request);
        return "redirect:/api/employees";
    }

    @PostMapping("/update/{employeeId}")
    public String update(@PathVariable("employeeId") int employeeId, @ModelAttribute("employee") UpdateEmployeeRequest request, Model model) {
        service.update(employeeId, request);
        return "redirect:/api/employees";
    }

    @GetMapping("/delete/{employeeId}")
    public String delete(@PathVariable("employeeId") int employeeId) {
        service.delete(employeeId);
        return "redirect:/api/employees";
    }

}
