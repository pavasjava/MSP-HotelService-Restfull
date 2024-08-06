package com.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "micro_user")
public class User {
    @Id
    @Column(name = "Id")
    private String userId;
    @Column(name = "Name",length = 20)
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "about")
    private String about;
    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
