package com.CRUD.opreation;

import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CRUD.opreation.entities.Student;
import com.CRUD.opreation.repository.StudentRepository;

@SpringBootTest
class CrudSpringBootApplicationTests {
	
	// Up casting object= bean , autowired is equality to CrudRepository , -- dependency injection is automatically required object are created
	@Autowired
	private StudentRepository studentRepo;
	//create 
	@Test
	void SaveOneStudent() {
		Student student = new Student(); 
		student.setName("AK");
		student.setCourse("PUC");
		student.setFee(10);
		studentRepo.save(student);
	}
	//Delete
	@Test
	void DeleteOneStudentById() {
		studentRepo.deleteById(10l);
	}
	
	//Read
	@Test
	void FindOneStudentByID() {
		Optional<Student> findById = studentRepo.findById(3l);
		// converting into optional  to student findById.get() control+1
		Student student = findById.get();
	      System.out.println(student.getName());
	      System.out.println(student.getCourse());
	      System.out.println(student.getFee());
	}
	@Test
	void findOneStudentByName() {
		Student student = studentRepo.findByName("sanju");
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
		System.out.println(student.getId());
	}
	@Test
	void findOneStudentByfee() {
		Student student = studentRepo.findByFee(55);
		System.out.println(student.getCourse());
		System.out.println(student.getName());
		System.out.println(student.getId());
	}
	//Update
	@Test
	void updateOneStudentById() {
		Optional<Student> findById = studentRepo.findById(6l);
		Student student = findById.get();
		student.setCourse("Diploma");
		studentRepo.save(student);
	}
	@Test
	void UpdateOnestudentByName() {
		Student student = studentRepo.findByName("vinod");
		student.setCourse("BCA");
		studentRepo.save(student);
	}
	@Test
	void getAllData() {
		Iterable<Student> findAll = studentRepo.findAll(); 
			for (Student student : findAll) {
				System.out.println(student.getId());
				System.out.println(student.getName());
				System.out.println(student.getCourse());
				System.out.println(student.getFee());
			}
		}
		}
