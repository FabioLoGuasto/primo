package com.service;
import java.util.ArrayList;
import java.util.List;
import org.jvnet.hk2.annotations.Service;
import com.repository.Student;
/*
 * QUA IMPLEMENTO I MIEI SERVIZI ED
 * OGNI AZIONE CHE HO QUA DENTRO ANDRò A CHIAMARLA DAL MIO CONTROLLER
 */
@Service
public class StudentServiceImplement implements StudentService{
	
	private static List<Student> listaStudenti = new ArrayList<>();
	
	static {
		Student s1 = new Student();
		s1.setId(1);
		s1.setNome("fabio");
		listaStudenti.add(s1);
		
		Student s2 = new Student();
		s1.setId(2);
		s1.setNome("luca");
		listaStudenti.add(s2);
	}
	

	@Override
	public void saveStudent(Student stud) {
		listaStudenti.add(stud);
	}
	
	
	@Override
	public void updateStudent(int id, Student stud) {
		for(Student l : listaStudenti) {
			if (l.getId() == id) {
				l.setId(10);
			}
		}
	}
	
	
	@Override
	public void deleteStudentById(int id) {
		for(Student l : listaStudenti) {
			if (l.getId() == id) {
				listaStudenti.remove(l);
			}
		}
	}
	
	
	@Override
	public void findAllStudent() {
		for(Student l : listaStudenti) {
			System.out.println(l);
		}
	}
	
	

	@Override
	public String findByName(String name) {
		return "trovato";
	}







}
