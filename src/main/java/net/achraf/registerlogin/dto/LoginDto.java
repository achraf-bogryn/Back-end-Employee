package net.achraf.registerlogin.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class LoginDto {
    private String email;
    private String password;
}
