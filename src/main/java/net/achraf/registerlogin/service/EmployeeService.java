package net.achraf.registerlogin.service;

import net.achraf.registerlogin.dto.EmployeeDto;
import net.achraf.registerlogin.dto.LoginDto;
import net.achraf.registerlogin.response.LoginMesage;

public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDTO);
    LoginMesage loginEmployee(LoginDto loginDto);

//    LoginResponse loginEmployee(LoginDto loginDTO);
}
