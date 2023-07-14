package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.LibroDAO;
import dao.RivistaDAO;
import enums.Periodicita;
import model.Libro;
import model.Rivista;

public class Main {
	private static final String URL = "jdbc:postgresql://localhost:5432/libreria?useSSL=false";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "Maiale97!";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			System.out.println("Connessione al database riuscita!");

			LibroDAO libroDAO = new LibroDAO();
			RivistaDAO rivistaDAO = new RivistaDAO();

			// Aggiunge un libro
			Libro libro = new Libro("123456789", "Titolo del libro", 2023, 200, "1", "Horror");
			libroDAO.aggiungiLibro(libro);
			System.out.println("Libro aggiunto con successo!");

			// Modifica un libro
			libro.setTitolo("Nuovo titolo del libro");
			libroDAO.updateLibro(libro);
			System.out.println("Libro modificato con successo!");

			// Elimina un libro
			String codiceISBN = "123456789";
			libroDAO.deleteLibro(codiceISBN);
			System.out.println("Libro eliminato con successo!");

			// Aggiunge una rivista
			Rivista rivista = new Rivista("987654321", "Titolo della rivista", 2023, 100, Periodicita.MENSILE);
			rivistaDAO.aggiungiRivista(rivista);
			System.out.println("Rivista aggiunta con successo!");

			// Modifica una rivista
			rivista.setTitolo("Nuovo titolo della rivista");
			rivistaDAO.updateRivista(rivista);
			System.out.println("Rivista modificata con successo!");

			// Elimina una rivista
			String codiceISBNRivista = "987654321";
			rivistaDAO.deleteRivista(codiceISBNRivista);
			System.out.println("Rivista eliminata con successo!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
