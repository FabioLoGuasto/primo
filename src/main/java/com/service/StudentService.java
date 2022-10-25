package com.service;

import java.util.List;
import com.repository.Student;

//DECIDO I MIEI SERVIZI

public interface StudentService {
	
	void saveStudent(Student stud);
	void updateStudent(int id,Student stud);
	void deleteStudentById(int id);
	void findAllStudent();
	
	String findByName(String name);
}
