package com.rjcon.crudDemo;

import com.rjcon.crudDemo.dao.StudentDAO;
import com.rjcon.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
		};
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

}
