package monRdv.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import monRdv.Application;
import monRdv.model.Adresse;
import monRdv.model.Creneaux;
import monRdv.model.Motif;
import monRdv.model.Patient;
import monRdv.model.Praticien;
import monRdv.model.PraticienAdresse;
import monRdv.model.PraticienMotif;
import monRdv.model.PraticienSpecialite;
import monRdv.model.RDV;
import monRdv.model.Specialite;
import monRdv.model.TypeUtilisateur;
import monRdv.model.Utilisateur;

public class TestMonRdvWithDao {

	public static void main(String[] args) throws ParseException {
		Application.getInstance();

		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Utilisateur userPatientDupont = new Utilisateur("dupont@hotmail.com", "12345", TypeUtilisateur.Patient);
		userPatientDupont = Application.getInstance().getDaoUtilisateur().save(userPatientDupont);

		Adresse adressePatientDupont = new Adresse(2, "rue Courbevoie", "75012", "Paris", "France");
		adressePatientDupont = Application.getInstance().getDaoAdresse().save(adressePatientDupont);

		Patient patientDupont = new Patient("Dupont", "Pierre", true);
		patientDupont.setAdresse(adressePatientDupont);
		patientDupont.setUtilisateur(userPatientDupont);
		patientDupont.setDtNaissance(sdfDate.parse("22/12/1980"));
		patientDupont = Application.getInstance().getDaoPatient().save(patientDupont);

		Patient patientDupontEnfant = new Patient("Dupont", "Laura", false);
		patientDupontEnfant.setAdresse(adressePatientDupont);
		patientDupontEnfant.setUtilisateur(userPatientDupont);
		patientDupontEnfant.setDtNaissance(sdfDate.parse("29/02/2016"));
		patientDupontEnfant = Application.getInstance().getDaoPatient().save(patientDupontEnfant);

		Praticien pediatre = new Praticien("LOUIS", "Emile", sdfDate.parse("01/04/1956"), true, true, true);
		pediatre = Application.getInstance().getDaoPraticien().save(pediatre);

		Specialite medecineGenerale = new Specialite("Médecine Générale");
		medecineGenerale = Application.getInstance().getDaoSpecialite().save(medecineGenerale);
		Application.getInstance().getDaoPraticienSpecialite().save(new PraticienSpecialite(pediatre, medecineGenerale));

		Specialite pediatrie = new Specialite("Pediatrie");
		pediatrie = Application.getInstance().getDaoSpecialite().save(pediatrie);
		Application.getInstance().getDaoPraticienSpecialite().save(new PraticienSpecialite(pediatre, pediatrie));

		Adresse adressePediatreCabinet = new Adresse(1, "rue de la paix", "75001", "Paris", "France");
		adressePediatreCabinet = Application.getInstance().getDaoAdresse().save(adressePediatreCabinet);
		Application.getInstance().getDaoPraticienAdresse().save(new PraticienAdresse(pediatre, adressePediatreCabinet));

		Adresse adressePediatreClinique = new Adresse(75, "rue Jeanne d'Arc", "75013", "Paris", "France");
		adressePediatreClinique = Application.getInstance().getDaoAdresse().save(adressePediatreClinique);
		Application.getInstance().getDaoPraticienAdresse()
				.save(new PraticienAdresse(pediatre, adressePediatreClinique));

		Motif premiereConsultation = new Motif("Première consultation", 35, 45);
		premiereConsultation = Application.getInstance().getDaoMotif().save(premiereConsultation);
		Application.getInstance().getDaoPraticienMotif().save(new PraticienMotif(pediatre, premiereConsultation));

		Motif suivi = new Motif("Consultation de suivi", 35, 30);
		suivi = Application.getInstance().getDaoMotif().save(suivi);
		Application.getInstance().getDaoPraticienMotif().save(new PraticienMotif(pediatre, suivi));

		Motif urgence = new Motif("Urgence pédiatrique", 15, 60);
		urgence = Application.getInstance().getDaoMotif().save(urgence);
		Application.getInstance().getDaoPraticienMotif().save(new PraticienMotif(pediatre, urgence));

		int heure = 8;
		int minute = 0;

		for (int i = 0; i < 16; i++) {

			Creneaux creneaux = new Creneaux(
					sdfDateTime.parse("18/01/2019 " + String.format("%01d:%01d", heure, minute)), 15);
			creneaux.setAdresse(adressePediatreCabinet);
			creneaux.setPraticien(pediatre);
			Application.getInstance().getDaoCreneaux().save(creneaux);

			minute += 15;

			if (minute == 60) {
				minute = 0;
				heure = heure + 1;
			}
		}

		heure = 13;
		minute = 30;

		for (int i = 0; i < 16; i++) {

			Creneaux creneaux = new Creneaux(
					sdfDateTime.parse("18/01/2019 " + String.format("%01d:%01d", heure, minute)), 15);
			creneaux.setAdresse(adressePediatreClinique);
			creneaux.setPraticien(pediatre);
			Application.getInstance().getDaoCreneaux().save(creneaux);

			minute += 15;

			if (minute == 60) {
				minute = 0;
				heure = heure + 1;
			}
		}

		RDV rdv = new RDV(pediatre, patientDupontEnfant, userPatientDupont, premiereConsultation);
		rdv = Application.getInstance().getDaoRDV().save(rdv);

		List<Creneaux> rdvCreneaux = Application.getInstance().getDaoCreneaux().findCreneauxByPraticienAndDateTime(
				pediatre, sdfDateTime.parse("18/01/2019 09:00"), premiereConsultation.getDuree());

		for (Creneaux creneau : rdvCreneaux) {
			creneau.setRdv(rdv);
			Application.getInstance().getDaoCreneaux().save(creneau);
		}

		Application.getInstance().getEmf().close();
	}

}
