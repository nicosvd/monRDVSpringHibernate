package fr.sopra.formation.monRdv.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Praticien {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private int version;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dtNaissance;
	private long numeroOrdre;
	private Integer tel;
	@Temporal(TemporalType.TIME)
	private Date horaireOuverture;
	private boolean cb;
	private boolean espece;
	private boolean cheque;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "praticien")
	private List<PraticienAdresse> adresses = new ArrayList<>();
	@OneToMany(mappedBy = "praticien")
	private List<PraticienSpecialite> specialites = new ArrayList<>();
	@OneToMany(mappedBy = "praticien")
	private List<PraticienMotif> motifs = new ArrayList<>();
	@OneToMany(mappedBy = "praticien")
	private List<Creneaux> creneaux = new ArrayList<>();
	@OneToMany(mappedBy = "praticien")
	private List<RDV> rdvs = new ArrayList<>();

	public Praticien() {
		super();
	}

	public Praticien(String nom, String prenom, Date dtNaissance, boolean cb, boolean espece, boolean cheque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dtNaissance = dtNaissance;
		this.cb = cb;
		this.espece = espece;
		this.cheque = cheque;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public long getNumeroOrdre() {
		return numeroOrdre;
	}

	public void setNumeroOrdre(long numeroOrdre) {
		this.numeroOrdre = numeroOrdre;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public Date getHoraireOuverture() {
		return horaireOuverture;
	}

	public void setHoraireOuverture(Date horaireOuverture) {
		this.horaireOuverture = horaireOuverture;
	}

	public boolean isCb() {
		return cb;
	}

	public void setCb(boolean cb) {
		this.cb = cb;
	}

	public boolean isEspece() {
		return espece;
	}

	public void setEspece(boolean espece) {
		this.espece = espece;
	}

	public boolean isCheque() {
		return cheque;
	}

	public void setCheque(boolean cheque) {
		this.cheque = cheque;
	}

	public List<PraticienAdresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<PraticienAdresse> adresses) {
		this.adresses = adresses;
	}

	public List<PraticienSpecialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<PraticienSpecialite> specialites) {
		this.specialites = specialites;
	}

	public List<PraticienMotif> getMotifs() {
		return motifs;
	}

	public void setMotifs(List<PraticienMotif> motifs) {
		this.motifs = motifs;
	}

	public List<Creneaux> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(List<Creneaux> creneaux) {
		this.creneaux = creneaux;
	}

	public List<RDV> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<RDV> rdvs) {
		this.rdvs = rdvs;
	}

}
