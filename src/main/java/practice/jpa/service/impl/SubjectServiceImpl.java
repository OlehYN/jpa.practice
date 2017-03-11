package practice.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import practice.jpa.dao.SubjectDao;
import practice.jpa.entity.Subject;
import practice.jpa.service.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectDao subjectDao;

	public List<Subject> getAll() {
		return subjectDao.getAll();
	}

	public Subject create(Subject obj) {
		return subjectDao.create(obj);
	}

	public Subject read(Long key) {
		return subjectDao.read(key);
	}

	public void update(Subject obj) {
		subjectDao.update(obj);
	}

	public boolean delete(Long key) {
		return subjectDao.delete(key);
	}

}
