package com.example.rest.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "address")
@EqualsAndHashCode(of = {"id"})
public class Address implements Serializable {

    @Id
    private String id;

    @Column(name = "zip_code")
    private String zipCode;

    @Column
    private String street;

    @Column
    private String number;

    @Column
    private String complement;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @OneToOne
    @JoinColumn(name = "fk_user")
    private Student student;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

}
