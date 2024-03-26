package com.example.Group.Forms;

import com.example.Group.Models.UserModel;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String email;

    public UserModel toUser(PasswordEncoder passwordEncoder){
        return new UserModel(username, passwordEncoder.encode(password), email);
    }
}

