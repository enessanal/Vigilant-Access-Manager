package com.enessanal.vam.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name="users")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    @Getter
    private String id;

    @Column(nullable=false, unique = true)
    @Getter @Setter
    @NonNull
    private String username;

//    @Column(nullable=false)
    @Setter
    private String password;

    @Getter @Setter
    private Timestamp createdTime;

    @Getter @Setter
    private Timestamp updatedTime;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    @OneToMany(mappedBy = "user")
    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL)
    private List<Asset> assets = new ArrayList<>();
}
