package monRdv.dao;

import java.util.Date;
import java.util.List;

import monRdv.model.Creneaux;
import monRdv.model.Praticien;

public interface IDaoCreneaux extends IDao<Creneaux, Integer>{
	List<Creneaux> findCreneauxByPraticienAndDateTime(Praticien praticien, Date dtRdv, int duree);
}
