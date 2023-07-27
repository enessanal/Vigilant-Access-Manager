package com.enessanal.vam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class UserAddDto
{
    @Size(min=3, max=20, message = "Username must be 3-20 characters")
    @NotBlank(message = "Username must not be blank")
    private String username;

    @Email(message = "Email must be a valid email address")
    @NotBlank(message = "Email must not be blank")
    private String email;

    @Size(min=6, message = "Password min lentgh is 6 characters")
    private String password;

    @Size(max=25, message = "First name max length is 25 characters")
    private String firstName;

    @Size(max=25, message = "Last name max length is 25 characters")
    private String lastName;
}
