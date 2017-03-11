package practice.jpa.dao.impl;

import org.springframework.stereotype.Repository;

import practice.jpa.dao.TeacherDao;
import practice.jpa.entity.Teacher;

@Repository
public class TeacherDaoImpl extends GenericDaoImpl<Teacher, Long> implements TeacherDao{

	@Override
	protected Class<Teacher> entityClass() {
		return Teacher.class;
	}

	@Override
	protected String getEntityName() {
		return "teacher";
	}

}
