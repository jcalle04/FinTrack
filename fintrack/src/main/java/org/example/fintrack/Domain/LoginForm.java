package org.example.fintrack.Domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    private String email;
    private String password;
}
