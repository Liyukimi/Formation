package com.objis.spring.demodatabase.service;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.objis.spring.demodatabase.dao.IEmployeDao;
import com.objis.spring.demodatabase.domaine.Employe;

@Named("employeService")
public class EmployeService implements IEmployeService {
	private static final Logger logger = LogManager.getLogger(EmployeService.class);
	/*
	 * indique que l'attribut employeDao est 'auto câblé' => va chercher selon le
	 * type de autowire (byName/byType) un bean qui correspond (ici dans la classe
	 * EmployeDao annoté par @Repository("employeDao")
	 * 
	 * Si conflit d'autowire avec byType car plusieurs impl�mentations de
	 * IEmployeDao on peut rajouter @Qualifier("idBean") où "idBean" est l'id du
	 * bean que l'on souhaite câbler
	 */
	@Inject
	private IEmployeDao employeDao;

	public IEmployeDao getEmployeDao() {
		return employeDao;
	}

	public void setEmployeDao(IEmployeDao employeDao) {
		this.employeDao = employeDao;
	}

	public Employe getEmployeById(int id) {
		return employeDao.getEmployeById(id);
	}

	public Employe getPartialEmployeById(int id) {
		return employeDao.getPartialEmployeById(id);
	}

	public Employe getEmployeByLogin(String login) {
		return employeDao.getEmployeByLogin(login);
	}

	public void saveEmploye(Employe employe) {
		employeDao.saveEmploye(employe);
	}

	public int getEmployesCount() {
		return employeDao.getEmployesCount();
	}

	public Collection<Employe> getAllEmployes() {
		return employeDao.getAllEmployes();
	}

	@PostConstruct
	public void onInit() {
		logger.info("Bean employeDao créé");
	}

	@PreDestroy
	public void onDestroy() {
		logger.info("Bean employeDao supprimé");
	}
}
