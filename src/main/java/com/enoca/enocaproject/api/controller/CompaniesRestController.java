package com.enoca.enocaproject.api.controller;

import com.enoca.enocaproject.business.abstracts.CompanyService;
import com.enoca.enocaproject.business.abstracts.CompanyService;
import com.enoca.enocaproject.business.dto.requests.create.CreateCompanyRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateCompanyRequest;
import com.enoca.enocaproject.business.dto.responses.create.CreateCompanyResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllCompaniesResponse;
import com.enoca.enocaproject.business.dto.responses.update.UpdateCompanyResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/rest/companies")
public class CompaniesRestController {
    private final CompanyService service;

    @GetMapping
    public List<GetAllCompaniesResponse> getAll() {
        return service.getAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCompanyResponse add(@RequestBody CreateCompanyRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCompanyResponse update(@PathVariable int id, @RequestBody UpdateCompanyRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
