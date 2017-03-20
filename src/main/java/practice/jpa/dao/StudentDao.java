package practice.jpa.dao;

import java.util.List;

import practice.jpa.entity.Student;

public interface StudentDao  extends GenericDao<Student, Long>{
	List<Student> getBestStudents();
	
	List<Student> maxSubjects();
}
