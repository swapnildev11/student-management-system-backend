package com.swapdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swapdev.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

public	List<Student> findByFirstName(String name);

public List<Student> findByLastName(String name);

public List<Student> findByAddress(String name);




public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

}
