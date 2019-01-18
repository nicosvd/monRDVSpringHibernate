package fr.sopra.formation.monRdv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.sopra.formation.monRdv.App;
import fr.sopra.formation.monRdv.beans.Adresse;
import fr.sopra.formation.monRdv.dao.IDaoAdresse;

public class DaoAdresseJpa implements IDaoAdresse {

	@Override
	public List<Adresse> findAll() {
		List<Adresse> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Adresse> query = em.createQuery("from Adresse", Adresse.class);

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
	public Adresse find(Integer id) {
		Adresse obj = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.find(Adresse.class, id);

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
	public Adresse save(Adresse obj) {
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
	public void delete(Adresse obj) {
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
