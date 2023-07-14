package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Libro;

public class LibroDAO {
	private static final String url = "jdbc:postgresql://localhost:5432/libreria?useSSL=false";
	private static final String username = "postgres";
	private static final String password = "Maiale97!";

	public void aggiungiLibro(Libro libro) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO libri (codiceisbn, titolo, anno, numeropagine, id_autore, id_genere) "
					+ "VALUES (?, ?, ?, ?, CAST(? AS INTEGER), ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, libro.getCodiceISBN().replaceAll("\\s", ""));
			statement.setString(2, libro.getTitolo());
			statement.setInt(3, libro.getAnnoPubblicazione());
			statement.setInt(4, libro.getNumeroPagine());
			statement.setString(5, libro.getAutore());
			statement.setInt(6, Integer.parseInt(libro.getGenere()));

			statement.executeUpdate();

			System.out.println("Libro aggiunto con successo!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Libro> getAllLibri() {
		List<Libro> libri = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM libri";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String codiceISBN = resultSet.getString("codiceisbn");
				String titolo = resultSet.getString("titolo");
				int annoPubblicazione = resultSet.getInt("anno");
				int numeroPagine = resultSet.getInt("numeropagine");
				String autore = resultSet.getString("id_autore");
				String genere = resultSet.getString("id_genere");

				Libro libro = new Libro(codiceISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
				libri.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libri;
	}

	public void updateLibro(Libro libro) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE libri SET titolo = ?, anno = ?, numeropagine = ?, id_autore = ?, id_genere = ? WHERE codiceisbn = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, libro.getTitolo());
			statement.setInt(2, libro.getAnnoPubblicazione());
			statement.setInt(3, libro.getNumeroPagine());
			statement.setString(4, libro.getAutore());
			statement.setString(5, libro.getGenere());
			statement.setString(6, libro.getCodiceISBN());

			statement.executeUpdate();
			System.out.println("Libro aggiornato con successo!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteLibro(String codiceISBN) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "DELETE FROM libri WHERE codiceisbn = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, codiceISBN);

			statement.executeUpdate();
			System.out.println("Libro eliminato con successo!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
