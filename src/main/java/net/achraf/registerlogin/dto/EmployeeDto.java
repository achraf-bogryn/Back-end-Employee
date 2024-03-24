package net.achraf.registerlogin.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class EmployeeDto {
    private int employeeid;
    private String employeename;
    private String email;
    private String password;
}
