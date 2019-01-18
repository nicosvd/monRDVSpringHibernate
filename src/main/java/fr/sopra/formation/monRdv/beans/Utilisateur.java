package fr.sopra.formation.monRdv.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private int version;
	private String mail;
	private String motDePasse;
	@Enumerated(EnumType.STRING)
	private TypeUtilisateur typeUtilisateur;
	@OneToMany(mappedBy = "utilisateur")
	private List<Patient> patients = new ArrayList<>();
	@OneToOne(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private Praticien praticien;
	@OneToMany(mappedBy = "utilisateur")
	private List<RDV> rdvs = new ArrayList<>();

	public Utilisateur() {
		super();
	}

	public Utilisateur(String mail, String motDePasse, TypeUtilisateur typeUtilisateur) {
		super();
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.typeUtilisateur = typeUtilisateur;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public TypeUtilisateur getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public List<RDV> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<RDV> rdvs) {
		this.rdvs = rdvs;
	}

}
