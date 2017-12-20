package com.objis.spring.demodatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.objis.spring.demodatabase.dao.IEmployeDao;
import com.objis.spring.demodatabase.domaine.Employe;

@Service("employeService")
public class EmployeService
{
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
}
