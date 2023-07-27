package com.enessanal.vam.controller;

import com.enessanal.vam.model.Asset;
import com.enessanal.vam.model.User;
import com.enessanal.vam.service.AssetService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vam/assets")
@RequiredArgsConstructor
public class AssetController
{
    private final AssetService assetService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Asset> getAssets(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        return assetService.getAssets(page, size, sortBy, direction);
    }
}
