package com.enoca.enocaproject.api.controller;

import com.enoca.enocaproject.business.abstracts.EmployeeService;
import com.enoca.enocaproject.business.dto.requests.create.CreateEmployeeRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateEmployeeRequest;
import com.enoca.enocaproject.business.dto.responses.create.CreateEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllEmployeesResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.update.UpdateEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/rest/employees")
public class EmployeesRestController {
    private final EmployeeService service;

    @GetMapping
    public List<GetAllEmployeesResponse> getAll() {
        return service.getAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEmployeeResponse add(@RequestBody CreateEmployeeRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateEmployeeResponse update(@PathVariable int id, @RequestBody UpdateEmployeeRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
