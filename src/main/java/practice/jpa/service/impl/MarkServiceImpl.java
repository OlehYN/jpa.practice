package practice.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import practice.jpa.dao.MarkDao;
import practice.jpa.entity.Mark;
import practice.jpa.entity.Student;
import practice.jpa.service.MarkService;

@Service
public class MarkServiceImpl implements MarkService {

	@Autowired
	private MarkDao markDao;

	@Autowired
	private TransactionTemplate transactionTemplate;

	public List<Mark> getAll() {
		return transactionTemplate.execute(new TransactionCallback<List<Mark>>() {
			public List<Mark> doInTransaction(TransactionStatus txStatus) {
				try {
					return markDao.getAll();
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
			}
		});
	}

	public Mark create(final Mark obj) {
		transactionTemplate.execute(new TransactionCallback<Void>() {
			public Void doInTransaction(TransactionStatus txStatus) {
				try {
					markDao.create(obj);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
		return obj;
	}

	public Mark read(final Long key) {
		return transactionTemplate.execute(new TransactionCallback<Mark>() {
			public Mark doInTransaction(TransactionStatus txStatus) {
				try {
					return markDao.read(key);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
			}
		});
	}

	public void update(final Mark obj) {
		transactionTemplate.execute(new TransactionCallback<Void>() {
			public Void doInTransaction(TransactionStatus txStatus) {
				try {
					markDao.update(obj);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
	}

	public boolean delete(final Long key) {
		return transactionTemplate.execute(new TransactionCallback<Boolean>() {
			public Boolean doInTransaction(TransactionStatus txStatus) {
				try {
					return markDao.delete(key);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
			}
		});
	}

	@Override
	public List<Mark> getMarksByStudent(final Student student) {
		return transactionTemplate.execute(new TransactionCallback<List<Mark>>() {
			public List<Mark> doInTransaction(TransactionStatus txStatus) {
				try {
					return markDao.getMarksByStudent(student);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
			}
		});
	}
}
