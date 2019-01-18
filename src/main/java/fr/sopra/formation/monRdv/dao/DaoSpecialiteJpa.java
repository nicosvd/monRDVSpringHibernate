package fr.sopra.formation.monRdv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.sopra.formation.monRdv.App;
import fr.sopra.formation.monRdv.beans.Specialite;
import fr.sopra.formation.monRdv.dao.IDaoSpecialite;

public class DaoSpecialiteJpa implements IDaoSpecialite {

	@Override
	public List<Specialite> findAll() {
		List<Specialite> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Specialite> query = em.createQuery("from Specialite", Specialite.class);

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
	public Specialite find(Integer id) {
		Specialite obj = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.find(Specialite.class, id);

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
	public Specialite save(Specialite obj) {
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
	public void delete(Specialite obj) {
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
