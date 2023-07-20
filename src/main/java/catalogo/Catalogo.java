package catalogo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.CatalogoDAO;
import entities.Genere;
import entities.Lettura;
import entities.Libro;
import entities.Periodicità;
import entities.Rivista;
import entities.Utente;
import jpautil.JpaUtil;

public class Catalogo {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();

		CatalogoDAO cat = new CatalogoDAO(em);

		// Aggiunta nuovi libri
		Libro bookOne = new Libro(9788867754312L, "Il Signore degli Anelli", 1954, 1138, "J.R.R. Tolkien",
				Genere.Fantasy);
		cat.salvataggioLetturaIfNotExists(bookOne);

		Libro bookTwo = new Libro(9788806213941L, "1984", 1949, 328, "George Orwell", Genere.Distopia);
		cat.salvataggioLetturaIfNotExists(bookTwo);

		Libro bookThree = new Libro(9788804668235L, "Crimini", 2017, 400, "Ferdinando Camon", Genere.Crime);
		cat.salvataggioLetturaIfNotExists(bookThree);

		// Aggiunta nuove riviste
		Rivista magazineOne = new Rivista(9772285237000L, "National Geographic", 2020, 96, Periodicità.Mensile);
		cat.salvataggioLetturaIfNotExists(magazineOne);

		Rivista magazineTwo = new Rivista(9771125274001L, "Wired", 2021, 116, Periodicità.Mensile);
		cat.salvataggioLetturaIfNotExists(magazineTwo);

		// Aggiunta nuovi utenti
		Utente userOne = new Utente(1001L, "Mario", "Rossi", LocalDate.of(1985, 5, 12));
		cat.salvataggioUtenteIfNotExists(userOne);

		Utente userTwo = new Utente(1002L, "Luca", "Verdi", LocalDate.of(1990, 9, 30));
		cat.salvataggioUtenteIfNotExists(userTwo);

		// Ricerca libri per ISBN
		System.out.println("Libro con ISBN 9788806213941: " + cat.findByIsbn(9788806213941L).getTitolo());
		System.out.println("Libro con ISBN 9788804668235: " + cat.findByIsbn(9788804668235L).getTitolo());

		// Eliminazione riviste per ISBN
		cat.findByIsbnAndDelete(9772285237000L);

		// Ricerca libri per autore
		List<Lettura> libriDiTolkien = cat.findAuthor("J.R.R. Tolkien");
		System.out.println("Libri scritti da J.R.R. Tolkien:");
		libriDiTolkien.forEach(libro -> System.out.println("- " + libro.getTitolo()));

		// Ricerca riviste per titolo
		List<Lettura> rivistaWired = cat.findTitle("Wired");
		if (!rivistaWired.isEmpty()) {
			rivistaWired.forEach(rivista -> {
				System.out.println(
						"Rivista trovata: " + rivista.getTitolo() + " (Numero pagine: " + rivista.getPagine() + ")");
			});
		} else {
			System.out.println("Rivista non trovata.");
		}
	}
}
