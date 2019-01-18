package monRdv.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import fr.sopra.formation.monRdv.App;
import fr.sopra.formation.monRdv.beans.Adresse;
import fr.sopra.formation.monRdv.beans.Creneaux;
import fr.sopra.formation.monRdv.beans.Motif;
import fr.sopra.formation.monRdv.beans.Patient;
import fr.sopra.formation.monRdv.beans.Praticien;
import fr.sopra.formation.monRdv.beans.PraticienAdresse;
import fr.sopra.formation.monRdv.beans.PraticienMotif;
import fr.sopra.formation.monRdv.beans.PraticienSpecialite;
import fr.sopra.formation.monRdv.beans.RDV;
import fr.sopra.formation.monRdv.beans.Specialite;
import fr.sopra.formation.monRdv.beans.TypeUtilisateur;
import fr.sopra.formation.monRdv.beans.Utilisateur;

public class TestMonRdvWithDao {

	public static void main(String[] args) throws ParseException {
		App.getInstance();

		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Utilisateur userPatientDupont = new Utilisateur("dupont@hotmail.com", "12345", TypeUtilisateur.Patient);
		userPatientDupont = App.getInstance().getDaoUtilisateur().save(userPatientDupont);

		Adresse adressePatientDupont = new Adresse(2, "rue Courbevoie", "75012", "Paris", "France");
		adressePatientDupont = App.getInstance().getDaoAdresse().save(adressePatientDupont);

		Patient patientDupont = new Patient("Dupont", "Pierre", true);
		patientDupont.setAdresse(adressePatientDupont);
		patientDupont.setUtilisateur(userPatientDupont);
		patientDupont.setDtNaissance(sdfDate.parse("22/12/1980"));
		patientDupont = App.getInstance().getDaoPatient().save(patientDupont);

		Patient patientDupontEnfant = new Patient("Dupont", "Laura", false);
		patientDupontEnfant.setAdresse(adressePatientDupont);
		patientDupontEnfant.setUtilisateur(userPatientDupont);
		patientDupontEnfant.setDtNaissance(sdfDate.parse("29/02/2016"));
		patientDupontEnfant = App.getInstance().getDaoPatient().save(patientDupontEnfant);

		Praticien pediatre = new Praticien("LOUIS", "Emile", sdfDate.parse("01/04/1956"), true, true, true);
		pediatre = App.getInstance().getDaoPraticien().save(pediatre);

		Specialite medecineGenerale = new Specialite("Médecine Générale");
		medecineGenerale = App.getInstance().getDaoSpecialite().save(medecineGenerale);
		App.getInstance().getDaoPraticienSpecialite().save(new PraticienSpecialite(pediatre, medecineGenerale));

		Specialite pediatrie = new Specialite("Pediatrie");
		pediatrie = App.getInstance().getDaoSpecialite().save(pediatrie);
		App.getInstance().getDaoPraticienSpecialite().save(new PraticienSpecialite(pediatre, pediatrie));

		Adresse adressePediatreCabinet = new Adresse(1, "rue de la paix", "75001", "Paris", "France");
		adressePediatreCabinet = App.getInstance().getDaoAdresse().save(adressePediatreCabinet);
		App.getInstance().getDaoPraticienAdresse().save(new PraticienAdresse(pediatre, adressePediatreCabinet));

		Adresse adressePediatreClinique = new Adresse(75, "rue Jeanne d'Arc", "75013", "Paris", "France");
		adressePediatreClinique = App.getInstance().getDaoAdresse().save(adressePediatreClinique);
		App.getInstance().getDaoPraticienAdresse()
				.save(new PraticienAdresse(pediatre, adressePediatreClinique));

		Motif premiereConsultation = new Motif("Première consultation", 35, 45);
		premiereConsultation = App.getInstance().getDaoMotif().save(premiereConsultation);
		App.getInstance().getDaoPraticienMotif().save(new PraticienMotif(pediatre, premiereConsultation));

		Motif suivi = new Motif("Consultation de suivi", 35, 30);
		suivi = App.getInstance().getDaoMotif().save(suivi);
		App.getInstance().getDaoPraticienMotif().save(new PraticienMotif(pediatre, suivi));

		Motif urgence = new Motif("Urgence pédiatrique", 15, 60);
		urgence = App.getInstance().getDaoMotif().save(urgence);
		App.getInstance().getDaoPraticienMotif().save(new PraticienMotif(pediatre, urgence));

		int heure = 8;
		int minute = 0;

		for (int i = 0; i < 16; i++) {

			Creneaux creneaux = new Creneaux(
					sdfDateTime.parse("18/01/2019 " + String.format("%01d:%01d", heure, minute)), 15);
			creneaux.setAdresse(adressePediatreCabinet);
			creneaux.setPraticien(pediatre);
			App.getInstance().getDaoCreneaux().save(creneaux);

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
			App.getInstance().getDaoCreneaux().save(creneaux);

			minute += 15;

			if (minute == 60) {
				minute = 0;
				heure = heure + 1;
			}
		}

		RDV rdv = new RDV(pediatre, patientDupontEnfant, userPatientDupont, premiereConsultation);
		rdv = App.getInstance().getDaoRDV().save(rdv);

		List<Creneaux> rdvCreneaux = App.getInstance().getDaoCreneaux().findCreneauxByPraticienAndDateTime(
				pediatre, sdfDateTime.parse("18/01/2019 09:00"), premiereConsultation.getDuree());

		for (Creneaux creneau : rdvCreneaux) {
			creneau.setRdv(rdv);
			App.getInstance().getDaoCreneaux().save(creneau);
		}

		App.getInstance().getEmf().close();
	}

}
