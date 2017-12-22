package com.objis.spring.demodatabase.domaine;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Utilisé pour mapper le résultat d'un SELECT avec les attributs de la classe
 * Employe
 */
public class EmployeRowMapper implements RowMapper<Employe> {
	public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employe employe = new Employe();
		employe.setId(rs.getInt("id"));
		employe.setLogin(rs.getString("login"));
		employe.setEmail(rs.getString("email"));
		employe.setNom(rs.getString("nom"));
		employe.setPrenom(rs.getString("prenom"));
		employe.setPassword(rs.getString("password"));
		employe.setRole(rs.getString("role"));
		return employe;

	}
}
