package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Libro;

public class LibroDAO {
	private EntityManager entityManager;

	public LibroDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void aggiungiLibro(Libro libro) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(libro);
			entityManager.getTransaction().commit();
			System.out.println("Libro aggiunto con successo!");
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public List<Libro> getAllLibri() {
		List<Libro> libri = new ArrayList<>();

		try {
			TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l", Libro.class);
			libri = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libri;
	}

	public void updateLibro(Libro libro) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(libro);
			entityManager.getTransaction().commit();
			System.out.println("Libro aggiornato con successo!");
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void deleteLibro(Libro libro) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(libro);
			entityManager.getTransaction().commit();
			System.out.println("Libro eliminato con successo!");
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
