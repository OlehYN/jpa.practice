package practice.jpa.service;

import java.util.List;

import practice.jpa.entity.Student;

public interface StudentService {
	List<Student> getAll();

	Student create(Student obj);

	Student read(Long key);

	void update(Student obj);

	boolean delete(Long key);
}
