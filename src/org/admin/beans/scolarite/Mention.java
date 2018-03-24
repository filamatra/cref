package org.admin.beans.scolarite;

public class Mention {
	private int id_mention;
	private String nom_mention;
	private int id_responsable;

	
	
	public Mention(int id_mention, String nom_mention, int id_responsable) {
		super();
		this.id_mention = id_mention;
		this.nom_mention = nom_mention;
		this.id_responsable = id_responsable;
	}
	
	
	public Mention(int id_mention, String nom_mention) {
		super();
		this.id_mention = id_mention;
		this.nom_mention = nom_mention;
	}


	public int getId_mention() {
		return id_mention;
	}
	public void setId_mention(int id_mention) {
		this.id_mention = id_mention;
	}
	public String getNom_mention() {
		return nom_mention;
	}
	public void setNom_mention(String nom_mention) {
		this.nom_mention = nom_mention;
	}
	public int getId_responsable() {
		return id_responsable;
	}
	public void setId_responsable(int id_responsable) {
		this.id_responsable = id_responsable;
	}


	@Override
	public String toString() {
		return "Mention [id_mention=" + id_mention + ", nom_mention=" + nom_mention + ", id_responsable="
				+ id_responsable + "]";
	}
	
	
	
}
