package fr.sopra.formation.monRdv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.sopra.formation.monRdv.App;
import fr.sopra.formation.monRdv.beans.Praticien;
import fr.sopra.formation.monRdv.dao.IDaoPraticien;

public class DaoPraticienJpa implements IDaoPraticien {

	@Override
	public List<Praticien> findAll() {
		List<Praticien> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Praticien> query = em.createQuery("from Praticien", Praticien.class);

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
	public Praticien find(Integer id) {
		Praticien obj = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.find(Praticien.class, id);

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
	public Praticien save(Praticien obj) {
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
	public void delete(Praticien obj) {
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
