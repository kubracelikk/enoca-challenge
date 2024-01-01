package com.enoca.enocaproject.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int companyId;
}
