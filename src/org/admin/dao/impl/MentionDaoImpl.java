package org.admin.dao.impl;

import java.sql.*;

import org.admin.dao.DaoFactory;
import org.admin.dao.DaoException;
import org.admin.dao.MentionDao;
import org.admin.beans.scolarite.Mention;
import java.util.List;
import java.util.ArrayList;



public class MentionDaoImpl implements MentionDao{
	private DaoFactory daoFactory;

	public MentionDaoImpl(DaoFactory daoFactory)
	{
		this.daoFactory = daoFactory;
	}

	public List<Mention> getAllMention() throws DaoException{
		List<Mention> mentions = new ArrayList<Mention>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;

		try{
			String query = "SELECT * FROM t_mention";
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(query);
			resultat = preparedStatement.executeQuery();

			while(resultat.next()){
				String nom_mention = resultat.getString("nom_mention");
				int id_mention = resultat.getInt("id_mention");
				Mention mention = new Mention(id_mention, nom_mention);
				// mention.setId_mention();
				// mention.setNom_mention();
				System.out.println(mention.getId_mention());
				System.out.println(mention.getNom_mention());
				mentions.add(mention);
			}


			connexion.close();
			preparedStatement.close();
			resultat.close();
		}catch (SQLException e) {
			throw new DaoException("Erreur SQL: "+e.getMessage());
		}

		return mentions;
	}
}