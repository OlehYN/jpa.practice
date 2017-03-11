package practice.jpa.dao.impl;

import org.springframework.stereotype.Repository;

import practice.jpa.dao.StudentDao;
import practice.jpa.entity.Student;

@Repository
public class StudentDaoImpl extends GenericDaoImpl<Student, Long> implements StudentDao{

	@Override
	protected Class<Student> entityClass() {
		return Student.class;
	}

	@Override
	protected String getEntityName() {
		return "student";
	}

}
