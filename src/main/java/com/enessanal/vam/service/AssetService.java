package com.enessanal.vam.service;

import com.enessanal.vam.model.Asset;
import com.enessanal.vam.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssetService
{
    private final AssetRepository assetRepository;

    public List<Asset> getAssets(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        int pageNumber = Math.max((page.orElse(1) - 1), 0);
        int pageSize = size.orElse(Integer.MAX_VALUE);
        String sortByParam = sortBy.orElse("createdTime");
        Sort.Direction directionParam = direction.isPresent() && direction.get().equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Page<Asset> paged = assetRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(directionParam, sortByParam)));
        return paged.getContent();
    }

    public List<Asset> getByUserId(String userId, Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        int pageNumber = Math.max((page.orElse(1) - 1), 0);
        int pageSize = size.orElse(Integer.MAX_VALUE);
        String sortByParam = sortBy.orElse("createdTime");
        Sort.Direction directionParam = direction.isPresent() && direction.get().equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        Page<Asset> paged = assetRepository.findAllByUserId(userId,PageRequest.of(pageNumber, pageSize, Sort.by(directionParam, sortByParam)));

        return paged.getContent();
    }
}
