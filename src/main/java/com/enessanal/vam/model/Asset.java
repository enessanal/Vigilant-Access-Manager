package com.enessanal.vam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="assets")
@ToString
public class Asset
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    @Getter
    private String id;

    @Column(name="host", nullable=false)
    @NonNull
    @Getter @Setter
    private String host;

    @Getter @Setter
    private int port;

    @Getter @Setter
    private String protocol;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private Timestamp createdTime;

    @Getter @Setter
    private Timestamp updatedTime;



    @Getter @Setter
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;


}
