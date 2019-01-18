package fr.sopra.formation.monRdv.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class RDV {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private int version;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motif_id")
	private Motif motif;
	@OneToMany(mappedBy = "rdv")
	private Set<Creneaux> creneaux = new HashSet<>();

	public RDV() {
		super();
	}

	public RDV(Praticien praticien, Patient patient, Utilisateur utilisateur, Motif motif) {
		super();
		this.praticien = praticien;
		this.patient = patient;
		this.utilisateur = utilisateur;
		this.motif = motif;
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

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

	public Set<Creneaux> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(Set<Creneaux> creneaux) {
		this.creneaux = creneaux;
	}

}
