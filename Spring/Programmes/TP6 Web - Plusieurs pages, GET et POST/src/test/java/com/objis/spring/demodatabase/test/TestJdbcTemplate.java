package com.objis.spring.demodatabase.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.objis.spring.demodatabase.dao.IEmployeDao;

import com.objis.spring.demodatabase.domaine.Employe;
import com.objis.spring.demodatabase.service.EmployeService;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TestJdbcTemplate
{
	Employe emp;

	private static final Logger logger = LogManager.getLogger(TestJdbcTemplate.class);
	private AnnotationConfigApplicationContext appContext;
	private IEmployeDao dao;
	private EmployeService service;

	@Before
	public void setUpJdbcTemplate() throws Exception
	{
		/*
		 * Charge l'application context du projet recherche les beans dans les packages
		 * donnés en paramètre
		 */
		appContext = new AnnotationConfigApplicationContext("com.objis.spring.demodatabase");
		service = (EmployeService) appContext.getBean("employeService");
		dao = (IEmployeDao) appContext.getBean("employeDao");
	}

	@After
	public void tearDown() throws Exception
	{
		appContext.close();
		emp = null;
	}

	// Test de la sauvegarde en BD
	// @Test
	public void testSaveEmploye()
	{
		emp = new Employe(10, "morad", "mdpobjis", "Morad", "HANAFI", "morad.hanafi@objis.com", "employe");
		dao.saveEmploye(emp);
	}

	// Test de méthode getEmployeById du bean employeDao
	@Test
	public void testGetEmployeById()
	{
		Employe employe = dao.getEmployeById(6);
		logger.info("BEAN DAO : " + employe.toString());
		assertNotNull(employe);
	}

	// Test de méthode getPartialEmployeById du bean employeDao
	@Test
	public void testGetPartialEmployeById()
	{
		Employe employe = dao.getPartialEmployeById(2);
		logger.info("BEAN DAO : " + employe.toString());
		assertNotNull(employe);
	}

	// Test de méthode getEmployeById du bean employeService
	@Test
	public void testGetEmployeByIdService()
	{
		Employe employe = service.getEmployeById(6);
		logger.info("SERVICE BEAN : " + employe.toString());
		assertNotNull(employe);
	}

}
