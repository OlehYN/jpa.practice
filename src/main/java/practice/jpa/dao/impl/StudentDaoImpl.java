package practice.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

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

	@Override
	public List<Student> getBestStudents() {
		Query query = em.createQuery("SELECT s "
				+ "FROM Student s "
				+ "WHERE NOT EXISTS "
					+ "(SELECT m "
					+ "FROM Mark m "
					+ "WHERE m.markGradebook IN (SELECT g FROM Gradebook g WHERE g.student = s AND g = m.markGradebook) AND m.mark < 91 )");
		
		return (List<Student>) query.getResultList();
	}

	@Override
	public List<Student> maxSubjects() {
		Query query = em.createQuery("SELECT s.studentId "
				+ "FROM Student s, Gradebook g, Mark m WHERE s = g.student AND g = m.markGradebook "
				+ "GROUP BY s.studentId "
				+ "HAVING NOT EXISTS "
				+ "(SELECT COUNT(m1.markId) AS count "
						+ "FROM Mark m1, Student s1, Gradebook g1 WHERE m1.markGradebook = g1 AND s1 = g1.student "
						+ "GROUP BY s1.studentId HAVING COUNT(m.markId) > COUNT(m.markId) ORDER BY COUNT(m.markId) DESC)");
		List<Long> ids = query.getResultList();
		
		List<Student> students = new ArrayList<>();
		
		for(Long id: ids)
			students.add(read(id));
		
		return students;
	}

}
