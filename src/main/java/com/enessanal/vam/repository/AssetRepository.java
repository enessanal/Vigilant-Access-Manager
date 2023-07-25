package com.enessanal.vam.repository;

import com.enessanal.vam.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String>
{
//    List<Asset> findAssetByUserId(String id);
//
//    @Transactional
//    void deleteByUserId(String id);
}