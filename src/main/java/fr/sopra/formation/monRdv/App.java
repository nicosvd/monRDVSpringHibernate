package fr.sopra.formation.monRdv;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.sopra.formation.monRdv.dao.IDaoAdresse;
import fr.sopra.formation.monRdv.dao.IDaoCreneaux;
import fr.sopra.formation.monRdv.dao.IDaoMotif;
import fr.sopra.formation.monRdv.dao.IDaoPatient;
import fr.sopra.formation.monRdv.dao.IDaoPraticien;
import fr.sopra.formation.monRdv.dao.IDaoPraticienAdresse;
import fr.sopra.formation.monRdv.dao.IDaoPraticienMotif;
import fr.sopra.formation.monRdv.dao.IDaoPraticienSpecialite;
import fr.sopra.formation.monRdv.dao.IDaoRDV;
import fr.sopra.formation.monRdv.dao.IDaoSpecialite;
import fr.sopra.formation.monRdv.dao.IDaoUtilisateur;
import monRdv.dao.jpa.DaoAdresseJpa;
import monRdv.dao.jpa.DaoCreneauxJpa;
import monRdv.dao.jpa.DaoMotifJpa;
import monRdv.dao.jpa.DaoPatientJpa;
import monRdv.dao.jpa.DaoPraticienAdresseJpa;
import monRdv.dao.jpa.DaoPraticienJpa;
import monRdv.dao.jpa.DaoPraticienMotifJpa;
import monRdv.dao.jpa.DaoPraticienSpecialiteJpa;
import monRdv.dao.jpa.DaoRDVJpa;
import monRdv.dao.jpa.DaoSpecialiteJpa;
import monRdv.dao.jpa.DaoUtilisateurJpa;

public class App {

	private static App instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
	private final IDaoAdresse daoAdresse = new DaoAdresseJpa();
	private final IDaoCreneaux daoCreneaux = new DaoCreneauxJpa();
	private final IDaoMotif daoMotif = new DaoMotifJpa();
	private final IDaoPatient daoPatient = new DaoPatientJpa();
	private final IDaoPraticien daoPraticien = new DaoPraticienJpa();
	private final IDaoPraticienAdresse daoPraticienAdresse = new DaoPraticienAdresseJpa();
	private final IDaoPraticienMotif daoPraticienMotif = new DaoPraticienMotifJpa();
	private final IDaoPraticienSpecialite daoPraticienSpecialite = new DaoPraticienSpecialiteJpa();
	private final IDaoRDV daoRDV = new DaoRDVJpa();
	private final IDaoSpecialite daoSpecialite = new DaoSpecialiteJpa();
	private final IDaoUtilisateur daoUtilisateur = new DaoUtilisateurJpa();

	private App() {
	}

	public static App getInstance() {
		if (instance == null) {
			instance = new App();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IDaoAdresse getDaoAdresse() {
		return daoAdresse;
	}

	public IDaoCreneaux getDaoCreneaux() {
		return daoCreneaux;
	}

	public IDaoMotif getDaoMotif() {
		return daoMotif;
	}

	public IDaoPatient getDaoPatient() {
		return daoPatient;
	}

	public IDaoPraticien getDaoPraticien() {
		return daoPraticien;
	}

	public IDaoPraticienAdresse getDaoPraticienAdresse() {
		return daoPraticienAdresse;
	}

	public IDaoPraticienMotif getDaoPraticienMotif() {
		return daoPraticienMotif;
	}

	public IDaoPraticienSpecialite getDaoPraticienSpecialite() {
		return daoPraticienSpecialite;
	}

	public IDaoRDV getDaoRDV() {
		return daoRDV;
	}

	public IDaoSpecialite getDaoSpecialite() {
		return daoSpecialite;
	}

	public IDaoUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}

}
