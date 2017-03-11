package practice.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import practice.jpa.dao.GradebookDao;
import practice.jpa.entity.Gradebook;
import practice.jpa.service.GradebookService;

@Service
@Transactional
public class GradebookServiceImpl implements GradebookService{
	
	@Autowired
	private GradebookDao gradebookDao;

	public List<Gradebook> getAll() {
		return gradebookDao.getAll();
	}

	public Gradebook read(Long key) {
		return gradebookDao.read(key);
	}

	public void update(Gradebook obj) {
		gradebookDao.update(obj);
	}

}
