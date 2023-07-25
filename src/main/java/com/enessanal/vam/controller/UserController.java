package com.enessanal.vam.controller;


import com.enessanal.vam.model.Asset;
import com.enessanal.vam.model.User;
import com.enessanal.vam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vam/users")
public class UserController
{

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}/assets")
    @ResponseStatus(HttpStatus.OK)
    public List<Asset> getUserAssets(@PathVariable String id)
    {
        return userService.getAssets(id);
    }


}
