package fr.sopra.formation.monRdv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.sopra.formation.monRdv.App;
import fr.sopra.formation.monRdv.beans.PraticienMotif;
import fr.sopra.formation.monRdv.dao.IDaoPraticienMotif;

public class DaoPraticienMotifJpa implements IDaoPraticienMotif {

	@Override
	public List<PraticienMotif> findAll() {
		List<PraticienMotif> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<PraticienMotif> query = em.createQuery("from PraticienMotif", PraticienMotif.class);

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
	public PraticienMotif find(Integer id) {
		PraticienMotif obj = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = App.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.find(PraticienMotif.class, id);

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
	public PraticienMotif save(PraticienMotif obj) {
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
	public void delete(PraticienMotif obj) {
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
