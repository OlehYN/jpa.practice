package practice.jpa.dao.impl;

import org.springframework.stereotype.Repository;

import practice.jpa.dao.GradebookDao;
import practice.jpa.entity.Gradebook;

@Repository
public class GradebookDaoImpl extends GenericDaoImpl<Gradebook, Long> implements GradebookDao{

	@Override
	protected Class<Gradebook> entityClass() {
		return Gradebook.class;
	}

	@Override
	protected String getEntityName() {
		return "gradebook";
	}

}
