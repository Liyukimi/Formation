package com.objis.spring.demodatabase.service;

import java.util.Collection;

import com.objis.spring.demodatabase.domaine.Employe;

public interface IEmployeService {

	public Employe getEmployeById(Long id);

	public Employe getEmployeByLogin(String login);

	public void saveEmploye(Employe employe);

	public Long getEmployesCount();

	public Collection<Employe> getAllEmployes();

	public void onInit();

	public void onDestroy();
}