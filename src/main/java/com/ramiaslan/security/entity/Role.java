package com.ramiaslan.security.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_role")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();

}
