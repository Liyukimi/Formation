package com.objis.spring.demodatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objis.spring.demodatabase.domaine.Employe;

@Repository
public interface IEmployeDao extends JpaRepository<Employe, Long> {

	public Employe findById(Long id);

	public Employe findByLogin(String login);

}