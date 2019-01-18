package fr.sopra.formation.monRdv.dao;

import java.util.Date;
import java.util.List;

import fr.sopra.formation.monRdv.beans.Creneaux;
import fr.sopra.formation.monRdv.beans.Praticien;

public interface IDaoCreneaux extends IDao<Creneaux, Integer>{
	List<Creneaux> findCreneauxByPraticienAndDateTime(Praticien praticien, Date dtRdv, int duree);
}
