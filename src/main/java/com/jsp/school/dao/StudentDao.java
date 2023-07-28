package com.jsp.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.school.dto.Student;

@Component
public class StudentDao {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;

//	Save the student
	public Student saveStudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(student!=null) {
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
			return student;
		}
		else {
			return null;
		}
	}
	
	public List<Student>  viewAllStudents(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String sql="SELECT s FROM Student s";
		Query query=entityManager.createQuery(sql);
		return query.getResultList();
	}
	
	public boolean deleteStudentById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student s=entityManager.find(Student.class,id);
		if(s!=null) {
			entityTransaction.begin();
			entityManager.remove(s);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
				
	}
}
