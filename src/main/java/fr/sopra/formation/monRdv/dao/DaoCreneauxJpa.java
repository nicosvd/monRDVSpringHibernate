package fr.sopra.formation.monRdv.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import fr.sopra.formation.monRdv.App;
import fr.sopra.formation.monRdv.beans.Creneaux;
import fr.sopra.formation.monRdv.beans.Praticien;
import fr.sopra.formation.monRdv.dao.IDaoCreneaux;

public class DaoCreneauxJpa implements IDaoCreneaux {

	@Override
	public List<Creneaux> findAll() {
		List<Creneaux> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Creneaux> query = em.createQuery("from Creneaux", Creneaux.class);

			liste = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return liste;
	}

	@Override
	public List<Creneaux> findCreneauxByPraticienAndDateTime(Praticien praticien, Date dtRdv, int duree) {
		List<Creneaux> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Calendar dtRdvEnd = Calendar.getInstance();
			dtRdvEnd.setTime(dtRdv);
			dtRdvEnd.add(Calendar.MINUTE, duree);

			TypedQuery<Creneaux> query = em.createQuery(
					"select c from Creneaux c where c.praticien = :praticien and c.date >= :dtRdvStart and c.date < :dtRdvEnd",
					Creneaux.class);
			query.setParameter("praticien", praticien);
			query.setParameter("dtRdvStart", dtRdv, TemporalType.TIMESTAMP);
			query.setParameter("dtRdvEnd", dtRdvEnd.getTime(), TemporalType.TIMESTAMP);

			liste = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return liste;
	}

	@Override
	public Creneaux find(Integer id) {
		Creneaux obj = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.find(Creneaux.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return obj;
	}

	@Override
	public Creneaux save(Creneaux obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.merge(obj);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return obj;
	}

	@Override
	public void delete(Creneaux obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			em.remove(em.merge(obj));

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
