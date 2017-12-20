package com.objis.spring.demodatabase.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.demodatabase.dao.EmployeDao;

import com.objis.spring.demodatabase.domaine.Employe;
import com.objis.spring.demodatabase.service.EmployeService;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TestJdbcTemplate
{
	Employe emp;
	private EmployeDao dao;
	private EmployeService service;

	private static final Logger logger = LogManager.getLogger(TestJdbcTemplate.class);

	@Before
	public void setUpJdbcTemplate() throws Exception
	{
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-dao.xml");

		dao = (EmployeDao) appContext.getBean("employeDao");
		service = (EmployeService) appContext.getBean("employeService");
	}

	@After
	public void tearDown() throws Exception
	{
		emp = null;
	}

	// Test de la sauvegarde en BD
	@Test
	public void testSaveEmploye()
	{
		emp = new Employe(10, "morad", "mdpobjis", "Morad", "HANAFI", "morad.hanafi@objis.com", "employe");
		dao.saveEmploye(emp);
	}

	// Test de méthode getEmployeById du bean employeDao2
	@Test
	public void testGetEmployeById()
	{
		Employe employe = dao.getEmployeById(6);
		logger.info("BEAN DAO2 : Employe " + employe.toString());
		assertNotNull(employe);
	}

	// Test de méthode getPartialEmployeById du bean employeDao2
	@Test
	public void testGetPartialEmployeById()
	{
		Employe employe = dao.getPartialEmployeById(2);
		logger.info("BEAN DAO2 : Employe " + employe.toString());
		assertNotNull(employe);
	}

	// Test de méthode getEmployeById du bean employeService
	@Test
	public void testGetEmployeByIdService()
	{
		Employe employe = service.getEmployeById(6);
		logger.info("SERVICE BEAN : Employe " + employe.toString());
		assertNotNull(employe);
	}
}
