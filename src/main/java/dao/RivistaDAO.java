package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Rivista;

public class RivistaDAO {
	private EntityManager entityManager;

	public RivistaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void aggiungiRivista(Rivista rivista) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(rivista);
			entityManager.getTransaction().commit();
			System.out.println("Rivista aggiunta con successo!");
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public List<Rivista> getAllRiviste() {
		List<Rivista> riviste = new ArrayList<>();

		try {
			TypedQuery<Rivista> query = entityManager.createQuery("SELECT r FROM Rivista r", Rivista.class);
			riviste = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return riviste;
	}

	public void updateRivista(Rivista rivista) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(rivista);
			entityManager.getTransaction().commit();
			System.out.println("Rivista aggiornata con successo!");
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void deleteRivista(String codiceISBN) {
		try {
			Rivista rivista = entityManager.find(Rivista.class, codiceISBN);
			if (rivista != null) {
				entityManager.getTransaction().begin();
				entityManager.remove(rivista);
				entityManager.getTransaction().commit();
				System.out.println("Rivista eliminata con successo!");
			} else {
				System.out.println("Rivista non trovata!");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
