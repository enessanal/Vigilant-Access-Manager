package com.enessanal.vam.dto;

import com.enessanal.vam.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter @Setter
public class AssetAddDto
{
    @NotBlank(message = "Hostname (or ip address) must not be blank")
    private String host;
    private int port;
    private String protocol;
    private String description;

    @NotBlank(message = "An asset must belong to a user")
    private String userId;
}
