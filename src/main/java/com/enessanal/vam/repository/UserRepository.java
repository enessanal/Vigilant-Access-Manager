package com.enessanal.vam.repository;

import com.enessanal.vam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String>
{
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    void deleteByUsername(String username);
    void deleteByEmail(String email);





//    @Query("SELECT count(a) FROM User u JOIN u.assets a WHERE u.id = :userId")
//    int countAssetsByUserId(@Param("userId") UUID userId);
}
