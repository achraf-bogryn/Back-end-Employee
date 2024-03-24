package net.achraf.registerlogin.service.impl;

import net.achraf.registerlogin.dto.EmployeeDto;
import net.achraf.registerlogin.dto.LoginDto;
import net.achraf.registerlogin.entity.Employee;
import net.achraf.registerlogin.repository.EmployeeRepo;
import net.achraf.registerlogin.response.LoginMesage;
import net.achraf.registerlogin.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeImpl  implements EmployeeService {

//    @Autowired
    private EmployeeRepo employeeRepo;
//    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addEmployee(EmployeeDto employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepo.save(employee);
        return employee.getEmployeename();
    }

    private   EmployeeDto employeeDTO;
    @Override
    public LoginMesage loginEmployee(LoginDto loginDTO) {
//        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Email not exits", false);
        }
    }
}
