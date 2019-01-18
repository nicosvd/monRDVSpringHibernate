package fr.sopra.formation.monRdv.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class PraticienSpecialite {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private int version;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specialite_id")
	private Specialite specialite;

	public PraticienSpecialite() {
		super();
	}

	public PraticienSpecialite(Praticien praticien, Specialite specialite) {
		super();
		this.praticien = praticien;
		this.specialite = specialite;
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

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

}
