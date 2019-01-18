package monRdv.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Creneaux {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private int version;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private int tempsCreneau;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rdv_id")
	private RDV rdv;

	public Creneaux() {
		super();
	}

	public Creneaux(Date date, int tempsCreneau) {
		super();
		this.date = date;
		this.tempsCreneau = tempsCreneau;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTempsCreneau() {
		return tempsCreneau;
	}

	public void setTempsCreneau(int tempsCreneau) {
		this.tempsCreneau = tempsCreneau;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public RDV getRdv() {
		return rdv;
	}

	public void setRdv(RDV rdv) {
		this.rdv = rdv;
	}

}
