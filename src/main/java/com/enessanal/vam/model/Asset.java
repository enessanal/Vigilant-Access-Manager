package com.enessanal.vam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;
import java.util.UUID;

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
    @ManyToOne
    @ToString.Exclude
    private User user;


}
