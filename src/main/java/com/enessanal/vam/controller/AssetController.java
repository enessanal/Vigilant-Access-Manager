package com.enessanal.vam.controller;

import com.enessanal.vam.model.Asset;
import com.enessanal.vam.service.AssetService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/assets")
@RequiredArgsConstructor
public class AssetController
{
    private final AssetService assetService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Assets", description = "Get assets with page, size and sort parameters.")
    public List<Asset> getAssets(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        return assetService.getAssets(page, size, sortBy, direction);
    }
}
