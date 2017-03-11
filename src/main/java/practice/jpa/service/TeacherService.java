package practice.jpa.service;

import java.util.List;

import practice.jpa.entity.Teacher;

public interface TeacherService {
	List<Teacher> getAll();

	Teacher create(Teacher obj);

	Teacher read(Long key);

	void update(Teacher obj);

	boolean delete(Long key);
}
