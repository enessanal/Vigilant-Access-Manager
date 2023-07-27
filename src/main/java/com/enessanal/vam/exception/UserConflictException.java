package com.enessanal.vam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserConflictException extends RuntimeException
{
    public UserConflictException(String message)
    {
        super(message);
    }
}
