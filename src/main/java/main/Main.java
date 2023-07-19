package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.LibroDAO;
import dao.RivistaDAO;
import model.Libro;
import model.Rivista;

public class Main {

	public static void main(String[] args) {
		// Credenziali per il database
		String url = "jdbc:postgresql://localhost:5432/libreria?useSSL=false";
		String username = "postgres";
		String password = "1234";

		try {
			// Connessione al database
			System.out.println("Connessione in corso al database...");
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connessione riuscita");

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Epicode-It-java3-D5");

			EntityManager entityManager = entityManagerFactory.createEntityManager();

			LibroDAO libroDAO = new LibroDAO(entityManager);
			RivistaDAO rivistaDAO = new RivistaDAO(entityManager);

			// Aggiunge un libro
			Libro libro = new Libro("123456789", "Titolo del libro");
			libroDAO.aggiungiLibro(libro);
			System.out.println("Libro aggiunto con successo!");

			// Modifica un libro
			libro.setTitolo("Nuovo titolo del libro");
			libroDAO.updateLibro(libro);
			System.out.println("Libro modificato con successo!");

			// Elimina un libro
			libroDAO.deleteLibro(libro);
			System.out.println("Libro eliminato con successo!");

			// Aggiunge una rivista
			Rivista rivista = new Rivista();
			rivistaDAO.aggiungiRivista(rivista);
			System.out.println("Rivista aggiunta con successo!");

			// Modifica una rivista
			rivista.setTitolo("Nuovo titolo della rivista");
			rivistaDAO.updateRivista(rivista);
			System.out.println("Rivista modificata con successo!");

			// Elimina una rivista
			rivistaDAO.deleteRivista(rivista.getCodiceISBN());
			System.out.println("Rivista eliminata con successo!");

			entityManager.close();
			entityManagerFactory.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
