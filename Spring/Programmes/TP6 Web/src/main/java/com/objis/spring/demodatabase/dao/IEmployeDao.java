package com.objis.spring.demodatabase.dao;

import java.util.Collection;

import com.objis.spring.demodatabase.domaine.Employe;

public interface IEmployeDao
{
	public Employe getEmployeById(int id);

	public Employe getPartialEmployeById(int id);

	public Employe getEmployeByLogin(String login);

	public void saveEmploye(Employe employe);

	public int getEmployesCount();

	public Collection<Employe> getAllEmployes();
}