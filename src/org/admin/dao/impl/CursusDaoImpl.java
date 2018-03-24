package org.admin.dao.impl;

import java.sql.*;

import org.admin.dao.CursusDao;
import org.admin.dao.DaoFactory;
import org.admin.dao.DaoException;
import org.admin.beans.scolarite.Inscription;
import org.admin.beans.scolarite.Cursus;

import java.util.List;
import java.util.ArrayList;

public class CursusDaoImpl implements CursusDao{
	private DaoFactory daoFactory;

	public CursusDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}

	public List<Inscription> getCursus(int id_etudiant) throws DaoException{
		List<Inscription> students = new ArrayList<Inscription>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;

		try{
			connexion = daoFactory.getConnection();
			String query = "SELECT * FROM t_inscription WHERE id_etudiant = ?";
			preparedStatement = connexion.prepareStatement(query);
			preparedStatement.setInt(1, id_etudiant);
			resultat = preparedStatement.executeQuery();

			while(resultat.next()){
				int id_parcours = resultat.getInt("id_parcours");
				String niveau = resultat.getString("niveau");
				String annee_u = resultat.getString("annee_u");
				String situation = resultat.getString("situation");
				String obs = resultat.getString("obs");
				String specialite = resultat.getString("specialite");
				Inscription inscris = new Inscription(id_etudiant, id_parcours, niveau, annee_u, situation, obs, specialite);

				students.add(inscris);
				System.out.println(inscris.toString());
			}

		}catch (SQLException e){
			throw new DaoException("Erreur SQL: "+e.getMessage());
		}

		return students;
	}


	public List<Cursus> getCursus() throws DaoException{
		List<Cursus> cursus = new ArrayList<Cursus>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;

		try{
			connexion = daoFactory.getConnection();
			String query = "SELECT * FROM \"Vue_cursus\"; ";
			preparedStatement = connexion.prepareStatement(query);
			resultat = preparedStatement.executeQuery();

			while(resultat.next()){
				int id_etudiant = resultat.getInt("id_etudiant");
				String nom = resultat.getString("nom");
				String prenoms = resultat.getString("prenoms");
				String nom_parcours = resultat.getString("nom_parcours");
				String nom_mention = resultat.getString("nom_mention");
				String niveau = resultat.getString("niveau");
				String annee_u = resultat.getString("annee_u");
				String situation = resultat.getString("situation");
				Cursus unCursus = new Cursus(id_etudiant, nom, prenoms, nom_parcours, nom_mention, niveau, annee_u, situation);
				System.out.println(unCursus.toString());

				cursus.add(unCursus);
			}

			connexion.close();
			preparedStatement.close();
			resultat.close();
		}catch (SQLException e){
			throw new DaoException("Erreur SQL: "+e.getMessage());
		}

		return cursus;
	}
}