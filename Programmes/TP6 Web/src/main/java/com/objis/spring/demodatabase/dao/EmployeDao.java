package com.objis.spring.demodatabase.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.objis.spring.demodatabase.domaine.Employe;
import com.objis.spring.demodatabase.domaine.EmployeRowMapper;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/* indique l'id du bean */
@Repository("employeDao")
public class EmployeDao implements IEmployeDao
{

	private static final Logger logger = LogManager.getLogger(EmployeDao.class);

	/* Injection depuis DataSourceConfig */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@PostConstruct
	public void onInit()
	{
		logger.info("Bean employeDao cr��");
	}

	@PreDestroy
	public void onDestroy()
	{
		logger.info("Bean employeDao supprim�");
	}

	// R�cup�re certains champs de Employe d�pendant du EmployeRowMapper d�fini dans
	// domaine
	public Employe getPartialEmployeById(int id)
	{
		final String EMPLOYE_GET = "SELECT id, login, email, password, prenom, nom, role FROM employe WHERE id=?";

		Employe employe = (Employe) jdbcTemplate.queryForObject(EMPLOYE_GET, new Object[]
		{ id }, new EmployeRowMapper());
		return employe;
	}

	// R�cup�re tous les champs de Employe
	public Employe getEmployeById(int id)
	{
		final String EMPLOYE_GET = "SELECT * FROM employe WHERE id=?";

		Employe employe = (Employe) jdbcTemplate.queryForObject(EMPLOYE_GET, new Object[]
		{ id }, new BeanPropertyRowMapper<Employe>(Employe.class));
		return employe;
	}

	public Employe getEmployeByLogin(String login)
	{
		return null;
	}

	// Sauvegarde via JdbcTemplate
	public void saveEmploye(Employe employe)
	{
		final String EMPLOYE_INSERT = "INSERT INTO Employe (id, login, password, prenom, nom, email, role) values (?,?,?,?,?,?,?)";

		// On r�cup�re et on utilise directement le jdbcTemplate
		jdbcTemplate.update(EMPLOYE_INSERT, new Object[]
		{ employe.getId(), employe.getLogin(), employe.getPassword(), employe.getPrenom(), employe.getNom(),
				employe.getEmail(), employe.getRole() });
	}

	public int getEmployesCount()
	{
		String sql = "SELECT COUNT(*) FROM CUSTOMER";

		int total = jdbcTemplate.queryForObject(sql, Integer.class);

		return total;
	}

	public List<Employe> getAllEmployes()
	{
		final String EMPLOYE_GET = "SELECT * FROM employe";

		List<Employe> listeEmployes = new ArrayList<Employe>();
				
		listeEmployes = jdbcTemplate.query(EMPLOYE_GET, new BeanPropertyRowMapper<Employe>(Employe.class)) ;
		return listeEmployes;
	}

	

}
