package com.enessanal.vam.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

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
