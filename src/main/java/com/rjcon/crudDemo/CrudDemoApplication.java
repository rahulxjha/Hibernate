package com.rjcon.crudDemo;

import com.rjcon.crudDemo.dao.StudentDAO;
import com.rjcon.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);


		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);
	}


	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 102;
		System.out.println("Deleting the student : "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id : primary key
		int studentId = 103;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change last name to "Jha"
		System.out.println("Updating student...");
		myStudent.setLastName("Jha");

		// Update the student
 		studentDAO.update(myStudent);

		 // Display the updated student
		System.out.println("Updated Student : "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudentList = studentDAO.findByLastName("Tiwari");

		for (Student list: theStudentList) {
			System.out.println(list);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get a list of students
		List<Student> theStudentList = studentDAO.findAll();

		// Display list of students
		for (Student list: theStudentList) {
			System.out.println(list);
		}
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// Create multiple student
		System.out.println("Creating new student objects...");
		Student student1 = new Student("Rahul", "Jha", "rj@gmail.com");
		Student student2 = new Student("Sumit", "Kumar", "as@gmail.com");
		Student student3 = new Student("Amit", "Kumar", "mt@gmail.com");

		// Save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create the student object
		System.out.println("Creating new student object...");
		Student student = new Student("Rahul", "Jha", "rj@gmail.com");

		// Save the student object
		System.out.println("Saving rhe student...");
		studentDAO.save(student);

		// Display id of the saved student
		System.out.println("Saved student. Generated id: "+ student.getId());
	}

	public void readStudent(StudentDAO studentDAO){
		// Retrieve student based on the id:primary key
		System.out.println("Fetching the student details...");
		Student student = studentDAO.findById(101);
		System.out.println("Found the details: " + student);
	}

}
