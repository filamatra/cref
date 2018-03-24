package org.admin.dao;

import org.admin.beans.scolarite.Student;
import org.admin.dao.DaoException;
import java.util.List;

public interface StudentDao{
	List<Student> getAllStudentByParcours(String parcours) throws DaoException;
	Student getStudentById(int id_etudiant) throws DaoException;
	int getIdparcours(String nom_parcours) throws DaoException;
}