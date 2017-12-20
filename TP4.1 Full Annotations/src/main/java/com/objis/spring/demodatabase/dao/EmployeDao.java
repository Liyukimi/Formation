package com.objis.spring.demodatabase.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

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

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDatasource(DataSource datasource)
	{
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@PostConstruct
	public void onInit()
	{
		logger.info("Bean employeDao créé");
	}

	@PreDestroy
	public void onDestroy()
	{
		logger.info("Bean employeDao supprimé");
	}

	// Récupère certains champs de Employe dépendant du EmployeRowMapper défini dans
	// domaine
	public Employe getPartialEmployeById(int id)
	{
		final String EMPLOYE_GET = "SELECT id, login, email, password, prenom, nom, role FROM employe WHERE id=?";

		Employe employe = (Employe) jdbcTemplate.queryForObject(EMPLOYE_GET, new Object[]
		{ id }, new EmployeRowMapper());
		return employe;
	}

	// Récupère tous les champs de Employe
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

		// On récupère et on utilise directement le jdbcTemplate
		jdbcTemplate.update(EMPLOYE_INSERT, new Object[]
		{ employe.getId(), employe.getLogin(), employe.getPassword(), employe.getPrenom(), employe.getNom(),
				employe.getEmail(), employe.getRole() });
	}

	public int getEmployesCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Employe> getAllEmployes()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
