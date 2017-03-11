package practice.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import practice.jpa.dao.TeacherDao;
import practice.jpa.entity.Teacher;
import practice.jpa.service.TeacherService;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherDao teacherDao;

	public List<Teacher> getAll() {
		return teacherDao.getAll();
	}

	public Teacher create(Teacher obj) {
		return teacherDao.create(obj);
	}

	public Teacher read(Long key) {
		return teacherDao.read(key);
	}

	public void update(Teacher obj) {
		teacherDao.update(obj);
	}

	public boolean delete(Long key) {
		return teacherDao.delete(key);
	}

}
