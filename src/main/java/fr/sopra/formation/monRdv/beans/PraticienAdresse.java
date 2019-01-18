package fr.sopra.formation.monRdv.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class PraticienAdresse {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private int version;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;

	public PraticienAdresse() {
		super();
	}

	public PraticienAdresse(Praticien praticien, Adresse adresse) {
		super();
		this.praticien = praticien;
		this.adresse = adresse;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
