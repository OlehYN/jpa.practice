package practice.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import practice.jpa.dao.StudentDao;
import practice.jpa.entity.Student;
import practice.jpa.service.StudentService;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, readOnly=true)
	public List<Student> getAll() {
		return studentDao.getAll();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Student create(Student obj) {
		return studentDao.create(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public Student read(Long key) {
		return studentDao.read(key);
	}

	public void update(Student obj) {
		studentDao.update(obj);
	}

	public boolean delete(Long key) {
		return studentDao.delete(key);
	}

	@Override
	public List<Student> getBestStudents() {
		return studentDao.getBestStudents();
	}

	@Override
	public List<Student> maxSubjects() {
		return studentDao.maxSubjects();
	}

}
