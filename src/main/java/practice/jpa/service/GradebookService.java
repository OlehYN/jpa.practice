package practice.jpa.service;

import java.util.List;

import practice.jpa.entity.Gradebook;

public interface GradebookService {
	List<Gradebook> getAll();

	Gradebook read(Long key);

	void update(Gradebook obj);
}
