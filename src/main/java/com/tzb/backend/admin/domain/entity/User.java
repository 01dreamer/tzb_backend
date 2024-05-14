package com.tzb.backend.admin.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tzb.backend.admin.enums.UserLevel;
import com.tzb.backend.admin.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author 29002
 */
@Entity(name = "fUser")
@Getter
@Setter
@Table(name = "frontend_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    private Integer score = 0;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus status = UserStatus.ACTIVE;

    @Enumerated(EnumType.ORDINAL)
    private UserLevel role = UserLevel.PUBLIC;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Profile profile;

}
