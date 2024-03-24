package net.achraf.registerlogin.employeeConctroller;

import net.achraf.registerlogin.dto.EmployeeDto;
import net.achraf.registerlogin.dto.LoginDto;
import net.achraf.registerlogin.response.LoginMesage;
import net.achraf.registerlogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto)
    {
//        LoginResponse loginResponse = employeeService.loginEmployee(loginDto);
//        return ResponseEntity.ok(loginResponse);
        LoginMesage loginMesage = employeeService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginMesage);
    }
}
