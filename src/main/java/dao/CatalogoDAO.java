package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Lettura;
import entities.Utente;

public class CatalogoDAO {

	private EntityManager em;

	public CatalogoDAO(EntityManager em) {
		this.em = em;
	}

	public void salvataggioLetturaIfNotExists(Lettura lettura) {
		em.getTransaction().begin();

		Lettura existingLettura = em.find(Lettura.class, lettura.getIsbn());

		if (existingLettura == null) {
			em.persist(lettura);
		} else {
			System.out.println("L'entità con ISBN " + lettura.getIsbn() + " esiste già nel database.");
		}

		em.getTransaction().commit();
	}

	public void salvataggioUtenteIfNotExists(Utente utente) {
		em.getTransaction().begin();

		Utente existingUtente = em.find(Utente.class, utente.getNumeroTessera());

		if (existingUtente == null) {
			em.persist(utente);
		} else {
			System.out.println("L'utente con ID " + utente.getNumeroTessera() + " esiste già nel database.");
		}

		em.getTransaction().commit();
	}

	public Lettura findByIsbn(long isbn) {
		return em.find(Lettura.class, isbn);
	}

	public List<Lettura> findAuthor(String author) {
		String query = "SELECT l FROM Lettura l WHERE TYPE(l) = Libro AND l.autore = :author";
		return em.createQuery(query, Lettura.class).setParameter("author", author).getResultList();
	}

	public List<Lettura> findTitle(String title) {
		String query = "SELECT l FROM Lettura l WHERE l.titolo LIKE :title";
		return em.createQuery(query, Lettura.class).setParameter("title", "%" + title + "%").getResultList();
	}

	public void findByIsbnAndDelete(long isbn) {
		em.getTransaction().begin();
		Lettura lettura = em.find(Lettura.class, isbn);
		if (lettura != null) {
			em.remove(lettura);
		}
		em.getTransaction().commit();
	}
}
