package practice.jpa.dao.impl;

import org.springframework.stereotype.Repository;

import practice.jpa.dao.MarkDao;
import practice.jpa.entity.Mark;

@Repository
public class MarkDaoImpl extends GenericDaoImpl<Mark, Long> implements MarkDao{

	@Override
	protected Class<Mark> entityClass() {
		return Mark.class;
	}

	@Override
	protected String getEntityName() {
		return "mark";
	}

}
