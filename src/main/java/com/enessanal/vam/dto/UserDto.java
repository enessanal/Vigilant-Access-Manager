package com.enessanal.vam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
@NoArgsConstructor
public class UserDto
{
    private String id;
    private String username;
    private String email;
    private Timestamp createdTime;
    private Timestamp updatedTime;
    private String firstName;
    private String lastName;
}
