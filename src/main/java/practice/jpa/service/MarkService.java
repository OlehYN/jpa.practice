package practice.jpa.service;

import java.util.List;

import practice.jpa.entity.Mark;

public interface MarkService {
	List<Mark> getAll();

	Mark create(Mark obj);

	Mark read(Long key);

	void update(Mark obj);

	boolean delete(Long key);
}
