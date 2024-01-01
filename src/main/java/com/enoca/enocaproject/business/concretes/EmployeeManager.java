package com.enoca.enocaproject.business.concretes;

import com.enoca.enocaproject.business.abstracts.EmployeeService;
import com.enoca.enocaproject.business.dto.requests.create.CreateEmployeeRequest;
import com.enoca.enocaproject.business.dto.requests.update.UpdateEmployeeRequest;
import com.enoca.enocaproject.business.dto.responses.create.CreateEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetAllEmployeesResponse;
import com.enoca.enocaproject.business.dto.responses.get.GetEmployeeResponse;
import com.enoca.enocaproject.business.dto.responses.update.UpdateEmployeeResponse;
import com.enoca.enocaproject.entities.Employee;
import com.enoca.enocaproject.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository repository;
    private final ModelMapper mapper;


    @Override
    public List<GetAllEmployeesResponse> getAll() {
        List<Employee> employees = repository.findAll();
        List<GetAllEmployeesResponse> response = employees
                .stream()
                .map(employee -> mapper.map(employee, GetAllEmployeesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee employee = repository.findById(id).orElseThrow();
        GetEmployeeResponse response = mapper.map(employee, GetEmployeeResponse.class);
        return response;
    }

    @Override
    public CreateEmployeeResponse add(CreateEmployeeRequest request) {
        Employee employee = mapper.map(request, Employee.class);
        employee.setId(0);
        repository.save(employee);
        CreateEmployeeResponse response = mapper.map(employee, CreateEmployeeResponse.class);

        return response;
    }

    @Override
    public UpdateEmployeeResponse update(int id, UpdateEmployeeRequest request) {
        Employee employee = mapper.map(request, Employee.class);
        employee.setId(id);
        repository.save(employee);
        UpdateEmployeeResponse response = mapper.map(employee, UpdateEmployeeResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
