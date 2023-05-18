package com.rjcon.crudDemo.dao;

import com.rjcon.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // Define field for Entity Manager
    @Autowired
    private EntityManager entityManager;

    // Inject Entity Manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save()
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
