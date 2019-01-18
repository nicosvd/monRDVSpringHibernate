package fr.sopra.formation.monRdv.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Specialite {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private int version;
	private String nom;
	@OneToMany(mappedBy = "specialite")
	private List<PraticienSpecialite> praticiens = new ArrayList<>();

	public Specialite() {
		super();
	}

	public Specialite(String nom) {
		super();
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<PraticienSpecialite> getPraticiens() {
		return praticiens;
	}

	public void setPraticiens(List<PraticienSpecialite> praticiens) {
		this.praticiens = praticiens;
	}

}
