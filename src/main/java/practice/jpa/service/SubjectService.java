package practice.jpa.service;

import java.util.List;

import practice.jpa.entity.Subject;

public interface SubjectService {
	List<Subject> getAll();

	Subject create(Subject obj);

	Subject read(Long key);

	void update(Subject obj);

	boolean delete(Long key);
}
