package com.enessanal.vam.controller;

import com.enessanal.vam.dto.UserAddDto;
import com.enessanal.vam.model.Asset;
import com.enessanal.vam.model.User;
import com.enessanal.vam.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController
{
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Users", description = "Get users with page, size and sort parameters.")
    public List<User> getUsers(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        return userService.getUsers(page, size, sortBy, direction);
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Count All Users", description = "")
    public Long countUsers()
    {
        return userService.countUsers();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get User By Id", description = "")
    public User getUserById(@PathVariable(required = true)  String id)
    {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get User By Username", description = "")
    public User getUserByUsername(@PathVariable(required = true) String username)
    {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get User By Email", description = "")
    public User getUserByEmail(@PathVariable String email)
    {
        return userService.getUserByEmail(email);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create User", description = "")
    public User addNewUser(@Valid @RequestBody UserAddDto userAddDto)
    {
        return userService.addUser(userAddDto);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete User By ID", description = "")
    public void deleteUserById(@PathVariable(required = true) String id)
    {
        userService.deleteById(id);
    }

    @DeleteMapping("/username/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete User By Username", description = "")
    public void deleteUserUsername(@PathVariable(required = true) String username)
    {
        userService.deleteByUsername(username);
    }

    @DeleteMapping("/email/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete User By Email", description = "")
    public void deleteUserByEmail(@PathVariable(required = true) String email)
    {
        userService.deleteByEmail(email);
    }

    @PostMapping("/{id}/assets")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add an Asset to A User", description = "")
    public Asset addAssetToUser(@PathVariable(required = true) String id, @Valid @RequestBody Asset asset)
    {
        return userService.addAsset(id, asset);
    }

    @GetMapping("/{id}/assets")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get User's Assets List", description = "")
    public List<Asset> getUserAssets(@PathVariable(required = true) String id,Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        return userService.getAssets(id,page,size,sortBy,direction);
    }
}
