package com.enessanal.vam.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.util.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    @Getter
    private String id;

    @Column(name="username", nullable=false, unique = true)
    @Getter @Setter
    @NonNull
    private String username;

    @Getter @Setter
    @Column(name="email", nullable=false, unique = true)
    @NonNull
    private String email;

    @Column(name="firstname", nullable=true, unique = false)
    @Getter @Setter
    private String firstName;

    @Column(name="lastname", nullable=true, unique = false)
    @Getter @Setter
    private String lastName;

    @Column(name="password", nullable=false)
    @Getter
    private String password;

    @Getter @Setter
    private Timestamp createdTime;

    @Getter @Setter
    private Timestamp updatedTime;

    @Getter @Setter
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
//    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Asset> assets;

    public void setPassword(String password)
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.password = bCryptPasswordEncoder.encode(password);
    }

}
