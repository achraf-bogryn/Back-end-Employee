package net.achraf.registerlogin.response;


import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ToString
public class LoginMesage {
    String message;
    Boolean status;
}
