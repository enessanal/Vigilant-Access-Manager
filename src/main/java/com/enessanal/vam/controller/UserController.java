package com.enessanal.vam.controller;

import com.enessanal.vam.dto.UserAddDto;
import com.enessanal.vam.model.User;
import com.enessanal.vam.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vam/users")
public class UserController
{
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        return userService.getAllUsers(page, size, sortBy, direction);
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long countUsers()
    {
        return userService.countUsers();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable(required = true)  String id)
    {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByUsername(@PathVariable(required = true) String username)
    {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByEmail(@PathVariable String email)
    {
        return userService.getUserByEmail(email);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User addNewUser(@Valid @RequestBody UserAddDto userAddDto)
    {
        return userService.addUser(userAddDto);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable(required = true) String id)
    {
        userService.deleteById(id);
    }

    @DeleteMapping("/username/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserUsername(@PathVariable(required = true) String username)
    {
        userService.deleteByUsername(username);
    }

    @DeleteMapping("/email/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByEmail(@PathVariable(required = true) String email)
    {
        userService.deleteByEmail(email);
    }






//    @GetMapping("/{id}/assets")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Asset> getUserAssets(@PathVariable String id)
//    {
//        return userService.getAssets(id);
//    }






}
