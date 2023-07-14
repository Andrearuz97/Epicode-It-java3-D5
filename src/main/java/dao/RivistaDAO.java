package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enums.Periodicita;
import model.Rivista;

public class RivistaDAO {
	private static final String url = "jdbc:postgresql://localhost:5432/gestione_eventi?useSSL=false";
	private static final String username = "postgres";
	private static final String password = "Maiale97!";

	public void aggiungiRivista(Rivista rivista) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO riviste (codiceISBN, titolo, annoPubblicazione, numeroPagine, periodicità) "
					+ "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, rivista.getCodiceISBN());
			statement.setString(2, rivista.getTitolo());
			statement.setInt(3, rivista.getAnnoPubblicazione());
			statement.setInt(4, rivista.getNumeroPagine());
			statement.setString(5, rivista.getPeriodicità().name());

			statement.executeUpdate();

			System.out.println("Rivista aggiunta con successo!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Rivista> getAllRiviste() {
		List<Rivista> riviste = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM riviste";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String codiceISBN = resultSet.getString("codiceISBN");
				String titolo = resultSet.getString("titolo");
				int annoPubblicazione = resultSet.getInt("annoPubblicazione");
				int numeroPagine = resultSet.getInt("numeroPagine");
				Periodicita periodicità = Periodicita.valueOf(resultSet.getString("periodicità"));

				Rivista rivista = new Rivista(codiceISBN, titolo, annoPubblicazione, numeroPagine, periodicità);
				riviste.add(rivista);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return riviste;
	}

	public void updateRivista(Rivista rivista) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE riviste SET titolo = ?, annoPubblicazione = ?, numeroPagine = ?, periodicità = ? WHERE codiceISBN = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, rivista.getTitolo());
			statement.setInt(2, rivista.getAnnoPubblicazione());
			statement.setInt(3, rivista.getNumeroPagine());
			statement.setString(4, rivista.getPeriodicità().name());
			statement.setString(5, rivista.getCodiceISBN());

			statement.executeUpdate();
			System.out.println("Rivista aggiornata con successo!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteRivista(String codiceISBN) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "DELETE FROM riviste WHERE codiceISBN = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, codiceISBN);

			statement.executeUpdate();
			System.out.println("Rivista eliminata con successo!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
