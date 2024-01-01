package com.enoca.enocaproject.business.abstracts;

import com.enoca.enocaproject.business.dto.requests.create.CreateEmployeeRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateEmployeeRequest;
import com.enoca.enocaproject.business.dto.responses.create.CreateEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllEmployeesResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.update.UpdateEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<GetAllEmployeesResponse> getAll();

    GetEmployeeResponse getById(int id);
    CreateEmployeeResponse add(CreateEmployeeRequest request);

    UpdateEmployeeResponse update(int id, UpdateEmployeeRequest request);

    void delete(int id);
}
