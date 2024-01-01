package com.enoca.enocaproject.business.abstracts;

import com.enoca.enocaproject.business.dto.requests.create.CreateCompanyRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateCompanyRequest;
import com.enoca.enocaproject.business.dto.responses.create.CreateCompanyResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllCompaniesResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetCompanyResponse;
import com.enoca.enocaproject.business.dto.responses.update.UpdateCompanyResponse;

import java.util.List;

public interface CompanyService {
    List<GetAllCompaniesResponse> getAll();

    GetCompanyResponse getById(int id);
    CreateCompanyResponse add(CreateCompanyRequest request);

    UpdateCompanyResponse update(int id, UpdateCompanyRequest request);

    void delete(int id);
}
