package monRdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Motif {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private int version;
	private String motif;
	private Integer prix;
	private Integer duree;
	@OneToMany(mappedBy = "motif")
	private List<PraticienMotif> praticiens = new ArrayList<>();

	public Motif() {
		super();
	}

	public Motif(String motif, Integer prix, Integer duree) {
		super();
		this.motif = motif;
		this.prix = prix;
		this.duree = duree;
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

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public List<PraticienMotif> getPraticiens() {
		return praticiens;
	}

	public void setPraticiens(List<PraticienMotif> praticiens) {
		this.praticiens = praticiens;
	}

}
