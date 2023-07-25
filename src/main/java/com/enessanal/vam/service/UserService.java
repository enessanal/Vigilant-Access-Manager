package com.enessanal.vam.service;

import com.enessanal.vam.model.Asset;
import com.enessanal.vam.model.User;
import com.enessanal.vam.repository.AssetRepository;
import com.enessanal.vam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public List<Asset> getAssets(String id)
    {
        User user = userRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return user.getAssets();
    }

    public User addUserAsset(User user, Asset asset)
    {
        asset.setUser(user);
        assetRepository.save(asset);
        return userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + user.getId()));

    }



}
