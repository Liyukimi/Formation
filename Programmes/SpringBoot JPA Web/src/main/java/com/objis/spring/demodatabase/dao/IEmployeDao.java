package com.objis.spring.demodatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.objis.spring.demodatabase.domaine.Employe;

public interface IEmployeDao extends JpaRepository<Employe, Long> {

	public Employe findById(Long id);

	public Employe findByLogin(String login);

}