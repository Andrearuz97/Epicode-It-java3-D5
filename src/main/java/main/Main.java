package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

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

			Scanner scanner = new Scanner(System.in);
			String risposta;

			// Aggiunge un libro
			System.out.print("Inserisci il codice ISBN del libro: ");
			String codiceISBNLibro = scanner.nextLine();

			System.out.print("Inserisci il titolo del libro: ");
			String titoloLibro = scanner.nextLine();

			System.out.print("Inserisci l'autore del libro: ");
			String autoreLibro = scanner.nextLine();

			System.out.print("Inserisci il genere del libro: ");
			String genereLibro = scanner.nextLine();

			Libro libro = new Libro(codiceISBNLibro, titoloLibro);
			libro.setAutore(autoreLibro);
			libro.setGenere(genereLibro);

			libroDAO.aggiungiLibro(libro);
			System.out.println("Libro aggiunto con successo!");

			// Modifica un libro
			System.out.print("Vuoi modificare il titolo del libro? (si/no): ");
			risposta = scanner.nextLine();
			if (risposta.equalsIgnoreCase("si")) {
				System.out.print("Inserisci il nuovo titolo del libro: ");
				titoloLibro = scanner.nextLine();
				libro.setTitolo(titoloLibro);
				libroDAO.updateLibro(libro);
				System.out.println("Libro modificato con successo!");
			}

			// Elimina un libro (se desiderato)
			System.out.print("Vuoi eliminare il libro? (si/no): ");
			risposta = scanner.nextLine();
			if (risposta.equalsIgnoreCase("si")) {
				libroDAO.deleteLibro(libro);
				System.out.println("Libro eliminato con successo!");
			}

			// Aggiunge una rivista
			System.out.print("Inserisci il codice ISBN della rivista: ");
			String codiceISBNRivista = scanner.nextLine();

			System.out.print("Inserisci il titolo della rivista: ");
			String titoloRivista = scanner.nextLine();

			System.out.print("Inserisci la periodicità della rivista (SETTIMANALE, MENSILE, SEMESTRALE): ");
			String periodicitaRivista = scanner.nextLine();

			Rivista rivista = new Rivista(codiceISBNRivista, titoloRivista, 0, periodicitaRivista);
			rivista.setPeriodicita(periodicitaRivista);

			rivistaDAO.aggiungiRivista(rivista);
			System.out.println("Rivista aggiunta con successo!");

			// Modifica una rivista
			System.out.print("Vuoi modificare il titolo della rivista? (si/no): ");
			risposta = scanner.nextLine();
			if (risposta.equalsIgnoreCase("si")) {
				System.out.print("Inserisci il nuovo titolo della rivista: ");
				titoloRivista = scanner.nextLine();
				rivista.setTitolo(titoloRivista);
				rivistaDAO.updateRivista(rivista);
				System.out.println("Rivista modificata con successo!");
			}

			// Elimina una rivista (se desiderato)
			System.out.print("Vuoi eliminare la rivista? (si/no): ");
			risposta = scanner.nextLine();
			if (risposta.equalsIgnoreCase("si")) {
				rivistaDAO.deleteRivista(rivista.getCodiceISBN());
				System.out.println("Rivista eliminata con successo!");
			}

			entityManager.close();
			entityManagerFactory.close();
			conn.close();
			scanner.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
