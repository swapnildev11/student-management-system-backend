package com.swapdev.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "college")
    @JsonIgnore   // 🔥 prevents infinite loop
    private List<Student> students;
}