package org.example.gamedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginFormDTO {
    private String phone;
    private String code;
    private String password;
}
