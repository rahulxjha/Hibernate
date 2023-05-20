package com.rjcon.crudDemo.dao;

import com.rjcon.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
