package com.objis.spring.demodatabase.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.dao.EmployeDao;
import com.objis.spring.domaine.Employe;


public class TestSpringDAO  {

	private Employe emp;
	private EmployeDao springDao;
	private ClassPathXmlApplicationContext appContext;

	@Before
	public void setUp() throws Exception {
		emp = new Employe(48, "douglas", "mdpdoug", "Douglas", "MBIANDOU", "douglas.mbiandou@objis.com", "employe");
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");

		springDao = (EmployeDao) appContext.getBean("employeDao");
	}

	@After
	public void tearDown() throws Exception {
		emp = null;
		appContext = null;
		springDao = null;
	}

	@Test
	public void testSaveEmploye() {
		springDao.save(emp);
	}
/*
	public void testFindOne() {
		Employe employe = springDao.findOne(1);
		assertNotNull(employe);
	}
*/	
	@Test
	public void testFindByEmail() {
		List<Employe> employe = springDao.findByEmail(emp.getEmail());
		for(Employe e : employe) {
			System.out.println(e.getEmail());
		}
		assertNotNull(employe);
	}
}
