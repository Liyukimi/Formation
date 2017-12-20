package com.objis.spring.demodatabase.service;

import com.objis.spring.demodatabase.dao.IEmployeDao;
import com.objis.spring.demodatabase.domaine.Employe;

public class EmployeService
{
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
