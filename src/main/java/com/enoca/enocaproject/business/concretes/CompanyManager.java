package com.enoca.enocaproject.business.concretes;

import com.enoca.enocaproject.business.abstracts.CompanyService;
import com.enoca.enocaproject.business.dto.requests.create.CreateCompanyRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateCompanyRequest;
import com.enoca.enocaproject.business.dto.responses.create.CreateCompanyResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllCompaniesResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetCompanyResponse;
import com.enoca.enocaproject.business.dto.responses.update.UpdateCompanyResponse;
import com.enoca.enocaproject.entities.Company;
import com.enoca.enocaproject.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {
    private final CompanyRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllCompaniesResponse> getAll() {
        List<Company> companies = repository.findAll();
        List<GetAllCompaniesResponse> response = companies
                .stream()
                .map(company -> mapper.map(company, GetAllCompaniesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCompanyResponse getById(int id) {
        Company company = repository.findById(id).orElseThrow();
        GetCompanyResponse response = mapper.map(company, GetCompanyResponse.class);
        return response;
    }


    @Override
    public CreateCompanyResponse add(CreateCompanyRequest request) {
        Company company = mapper.map(request, Company.class);
        company.setId(0);
        repository.save(company);
        CreateCompanyResponse response = mapper.map(company, CreateCompanyResponse.class);

        return response;
    }

    @Override
    public UpdateCompanyResponse update(int id, UpdateCompanyRequest request) {
        Company company = mapper.map(request, Company.class);
        company.setId(id);
        repository.save(company);
        UpdateCompanyResponse response = mapper.map(company, UpdateCompanyResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
