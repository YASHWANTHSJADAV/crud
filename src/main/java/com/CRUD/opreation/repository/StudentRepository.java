package com.CRUD.opreation.repository;

import org.springframework.data.repository.CrudRepository;

import com.CRUD.opreation.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
		Student	findByName(String name);
		Student findByFee(int fee);
}
