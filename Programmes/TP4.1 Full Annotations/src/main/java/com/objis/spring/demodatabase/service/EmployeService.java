package com.objis.spring.demodatabase.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.objis.spring.demodatabase.dao.IEmployeDao;
import com.objis.spring.demodatabase.domaine.Employe;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Service("employeService")
public class EmployeService
{
	private static final Logger logger = LogManager.getLogger(EmployeService.class);
	/*
	 * indique que l'attribut employeDao est 'auto câblé' => va chercher selon le
	 * type de autowire (byName/byType) un bean qui correspond (ici dans la classe
	 * EmployeDao annoté par @Repository("employeDao")
	 * 
	 * Si conflit d'autowire avec byType car plusieurs implémentations de
	 * IEmployeDao on peut rajouter @Qualifier("idBean") où "idBean" est l'id du
	 * bean que l'on souhaite câbler
	 */
	@Autowired
	@Qualifier("employeDao")
	private IEmployeDao employeDao;

	public IEmployeDao getEmployeDao()
	{
		return employeDao;
	}

	public void setEmployeDao(IEmployeDao employeDao)
	{
		this.employeDao = employeDao;
	}

	public Employe getEmployeById(int id)
	{
		return employeDao.getEmployeById(id);
	}

	@PostConstruct
	public void onInit()
	{
		logger.info("Bean employeDao créé");
	}

	@PreDestroy
	public void onDestroy()
	{
		logger.info("Bean employeDao supprimé");
	}
}
