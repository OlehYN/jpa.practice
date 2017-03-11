package practice.jpa.dao.impl;

import org.springframework.stereotype.Repository;

import practice.jpa.dao.SubjectDao;
import practice.jpa.entity.Subject;

@Repository
public class SubjectDaoImpl extends GenericDaoImpl<Subject, Long> implements SubjectDao{

	@Override
	protected Class<Subject> entityClass() {
		return Subject.class;
	}

	@Override
	protected String getEntityName() {
		return "subject";
	}

}
