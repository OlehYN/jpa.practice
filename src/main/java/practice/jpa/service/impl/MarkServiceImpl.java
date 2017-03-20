package practice.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import practice.jpa.dao.MarkDao;
import practice.jpa.entity.Mark;
import practice.jpa.entity.Student;
import practice.jpa.service.MarkService;

@Service
@Transactional
public class MarkServiceImpl implements MarkService{
	
	@Autowired
	private MarkDao markDao;

	public List<Mark> getAll() {
		return markDao.getAll();
	}

	public Mark create(Mark obj) {
		return markDao.create(obj);
	}

	public Mark read(Long key) {
		return markDao.read(key);
	}

	public void update(Mark obj) {
		markDao.update(obj);
	}

	public boolean delete(Long key) {
		return markDao.delete(key);
	}

	@Override
	public List<Mark> getMarksByStudent(Student student) {
		return markDao.getMarksByStudent(student);
	}

}
