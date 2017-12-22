package com.objis.spring.demodatabase.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.objis.spring.demodatabase.domaine.Employe;
import com.objis.spring.demodatabase.domaine.EmployeRowMapper;

public class EmployeDao implements IEmployeDao
{

	/* Injection d'un JdbcTemplate, classe fournie par SpringFramework */
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) // important pour l'injection
	{
		this.jdbcTemplate = jdbcTemplate;
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
		return 0;
	}

	public List<Employe> getAllEmployes()
	{
		return null;
	}

}
