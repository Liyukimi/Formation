package com.objis.spring.demodatabase.service;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objis.spring.demodatabase.dao.IEmployeDao;
import com.objis.spring.demodatabase.domaine.Employe;

@Service
public class EmployeService implements IEmployeService {
	private static final Logger logger = LogManager.getLogger(EmployeService.class);

	@Autowired
	private IEmployeDao employeDao;

	public Employe getEmployeById(Long id) {
		return employeDao.findById(id);
	}

	public Employe getEmployeByLogin(String login) {
		return employeDao.findByLogin(login);
	}

	public void saveEmploye(Employe employe) {
		employeDao.save(employe);
	}

	public Long getEmployesCount() {
		return employeDao.count();
	}

	public Collection<Employe> getAllEmployes() {
		return employeDao.findAll();
	}

	@PostConstruct
	public void onInit() {
		logger.info("Bean employeService créé");
	}

	@PreDestroy
	public void onDestroy() {
		logger.info("Bean employeService supprimé");
	}

}
