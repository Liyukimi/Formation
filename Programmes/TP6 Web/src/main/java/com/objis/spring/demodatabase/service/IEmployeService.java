package com.objis.spring.demodatabase.service;

import java.util.Collection;
import java.util.List;


import com.objis.spring.demodatabase.dao.IEmployeDao;
import com.objis.spring.demodatabase.domaine.Employe;

public interface IEmployeService {
	
	public void setEmployeDao(IEmployeDao employeDao);

	public Employe getEmployeById(int id);

	public Employe getPartialEmployeById(int id);
	
	public Employe getEmployeByLogin(String login);
	
	public void saveEmploye(Employe employe);

	public int getEmployesCount();
	
	public Collection<Employe> getAllEmployes();
	
	public void onInit();

	public void onDestroy();
}
