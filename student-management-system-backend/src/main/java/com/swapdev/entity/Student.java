package com.swapdev.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String address;
    private Long phoneNo;
    private String email;
    private String course;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;
}