package com.ucr.smas.model;

import jakarta.persistence.*;

@Entity
@Table(name="tb-user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
}
