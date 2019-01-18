package monRdv;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import monRdv.dao.IDaoAdresse;
import monRdv.dao.IDaoCreneaux;
import monRdv.dao.IDaoMotif;
import monRdv.dao.IDaoPatient;
import monRdv.dao.IDaoPraticien;
import monRdv.dao.IDaoPraticienAdresse;
import monRdv.dao.IDaoPraticienMotif;
import monRdv.dao.IDaoPraticienSpecialite;
import monRdv.dao.IDaoRDV;
import monRdv.dao.IDaoSpecialite;
import monRdv.dao.IDaoUtilisateur;
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

public class Application {

	private static Application instance = null;

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

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
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
