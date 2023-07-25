package com.enessanal.vam.service;

import com.enessanal.vam.model.Asset;
import com.enessanal.vam.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetService
{
    private final AssetRepository assetRepository;

    public List<Asset> getAssets()
    {
        return assetRepository.findAll();
    }
}
