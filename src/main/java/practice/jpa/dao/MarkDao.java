package practice.jpa.dao;

import java.util.List;

import practice.jpa.entity.Mark;
import practice.jpa.entity.Student;

public interface MarkDao  extends GenericDao<Mark, Long>{
	List<Mark> getMarksByStudent(Student student);
}
