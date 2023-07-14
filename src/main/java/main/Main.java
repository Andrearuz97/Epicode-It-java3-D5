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
	static Connection conn = null;

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/Libreria?useSSL=false";
		String username = "postgres";
		String password = "Maiale97!";

		try {
			System.out.println("Connessione al database...");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connessione riuscita!");

			// Aggiunge libro
			Libro libro = new Libro("123456789", "Titolo del libro", 2023, 200, "Autore del libro", "Genere del libro");
			LibroDAO libroDAO = new LibroDAO();
			libroDAO.aggiungiLibro(libro);
			System.out.println("Libro aggiunto con successo!");

			// Modifica un libro
			libro.setTitolo("Nuovo titolo del libro");
			libroDAO.updateLibro(libro);
			System.out.println("Libro modificato con successo!");

			// eliminazione di un libro
			String codiceISBN = "123456789";
			libroDAO.deleteLibro(codiceISBN);
			System.out.println("Libro eliminato con successo!");

			// aggiunta di una rivista
			Rivista rivista = new Rivista("987654321", "Titolo della rivista", 2023, 100, Periodicita.MENSILE);
			RivistaDAO rivistaDAO = new RivistaDAO();
			rivistaDAO.aggiungiRivista(rivista);
			System.out.println("Rivista aggiunta con successo!");

			// modifica di una rivista
			rivista.setTitolo("Nuovo titolo della rivista");
			rivistaDAO.updateRivista(rivista);
			System.out.println("Rivista modificata con successo!");

			// eliminazione di una rivista
			String codiceISBNRivista = "987654321";
			rivistaDAO.deleteRivista(codiceISBNRivista);
			System.out.println("Rivista eliminata con successo!");

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
