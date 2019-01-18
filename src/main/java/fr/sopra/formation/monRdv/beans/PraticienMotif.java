package fr.sopra.formation.monRdv.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class PraticienMotif {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private int version;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motif_id")
	private Motif motif;

	public PraticienMotif() {
		super();
	}

	public PraticienMotif(Praticien praticien, Motif motif) {
		super();
		this.praticien = praticien;
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

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

}
