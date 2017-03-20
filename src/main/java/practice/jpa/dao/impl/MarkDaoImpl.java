package practice.jpa.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.googlecode.ehcache.annotations.Cacheable;

import practice.jpa.dao.MarkDao;
import practice.jpa.entity.Mark;
import practice.jpa.entity.Student;

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

	@Override
	@Cacheable(cacheName = "studentsCache")
	public List<Mark> getMarksByStudent(Student student) {
		Query query = em.createQuery("SELECT m FROM Mark AS m WHERE m.markGradebook in (SELECT s.gradebook FROM Student s WHERE s.studentId = :id)");
		query.setParameter("id", student.getStudentId());
		
		System.out.println("Method execution :c");
		
		return (List<Mark>) query.getResultList();
	}

}
