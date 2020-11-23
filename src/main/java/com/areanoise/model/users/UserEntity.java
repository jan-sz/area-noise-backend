package com.areanoise.model.users;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 1, allocationSize=1)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Basic
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Basic
    @Column(name = "FAVORITE_ANIMAL", nullable = false)
    private String favoriteAnimal;
}