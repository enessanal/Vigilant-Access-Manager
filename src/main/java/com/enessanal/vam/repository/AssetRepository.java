package com.enessanal.vam.repository;

import com.enessanal.vam.model.Asset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String>
{
    Page<Asset> findAllByUserId(String userId, Pageable pageable);
}