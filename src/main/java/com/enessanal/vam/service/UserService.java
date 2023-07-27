package com.enessanal.vam.service;

import com.enessanal.vam.dto.UserAddDto;
import com.enessanal.vam.exception.UserConflictException;
import com.enessanal.vam.exception.UserNotFoundException;
import com.enessanal.vam.model.Asset;
import com.enessanal.vam.model.User;
import com.enessanal.vam.repository.AssetRepository;
import com.enessanal.vam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.sql.Timestamp;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;
    private final AssetService assetService;

    public List<User> getUsers(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        int pageNumber = Math.max((page.orElse(1) - 1), 0);
        int pageSize = size.orElse(Integer.MAX_VALUE);
        String sortByParam = sortBy.orElse("createdTime");
        Sort.Direction directionParam = direction.isPresent() && direction.get().equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Page<User> userPage = userRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(directionParam, sortByParam)));
        return userPage.getContent();
    }

    public Long countUsers()
    {
        return userRepository.count();
    }

    public User getUserById(String id)
    {
        return userRepository.findById(id).orElseThrow( () -> new UserNotFoundException("Invalid id"));
    }

    public User getUserByUsername(String username)
    {
        return userRepository.findByUsername(username).orElseThrow( () -> new UserNotFoundException("Invalid username"));
    }

    public User getUserByEmail(String email)
    {
        return userRepository.findByEmail(email).orElseThrow( () -> new UserNotFoundException("Invalid email"));
    }

    @Transactional
    public void deleteById(String id)
    {
        if(userRepository.findById(id).isEmpty())
            throw new UserNotFoundException("Invaid id");

        userRepository.deleteById(id);
    }

    @Transactional
    public void deleteByUsername(String username)
    {
        if(userRepository.findByUsername(username).isEmpty())
            throw new UserNotFoundException("Invaid username");

        userRepository.deleteByUsername(username);
    }

    @Transactional
    public void deleteByEmail(String email)
    {
        if(userRepository.findByEmail(email).isEmpty())
            throw new UserNotFoundException("Invaid email");

        userRepository.deleteByEmail(email);
    }

    public User addUser(UserAddDto userAddDto)
    {
        Timestamp createdTime = new Timestamp(System.currentTimeMillis());

        if(userRepository.findByUsername(userAddDto.getUsername()).isPresent())
            throw new UserConflictException("Username already exists");

        if(userRepository.findByEmail(userAddDto.getEmail()).isPresent())
            throw new UserConflictException("Email already exists");


        User user = new User();

        /*
        * TODO
        * Add to DTO auto-mapping to entity
         */

        user.setUsername(userAddDto.getUsername());
        user.setPassword(userAddDto.getPassword());
        user.setEmail(userAddDto.getEmail());
        user.setFirstName(userAddDto.getFirstName());
        user.setLastName(userAddDto.getLastName());
        user.setCreatedTime(createdTime);


        user = userRepository.save(user);

        return user;
    }

    public Asset addAsset(String userId, Asset asset)
    {
        User user = userRepository.findById(userId).orElseThrow( () -> new UserNotFoundException("Invalid user id"));

        asset.setUser(user);
        return assetRepository.save(asset);
    }

    public List<Asset> getAssets(String userID,Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        User user = userRepository.findById(userID).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

//        return user.getAssets();
        return assetService.getByUserId(userID, page, size, sortBy, direction);
    }











}
