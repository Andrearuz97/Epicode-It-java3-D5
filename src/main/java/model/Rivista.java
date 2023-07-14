package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.Periodicita;

@Entity
@Table(name = "riviste")
public class Rivista {
	@Id
	private String codiceISBN;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;
	private Periodicita periodicità;

	public Rivista() {
	}

	public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicità) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
		this.periodicità = periodicità;
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public Periodicita getPeriodicità() {
		return periodicità;
	}

	public void setPeriodicità(Periodicita periodicità) {
		this.periodicità = periodicità;
	}

	@Override
	public String toString() {
		return "Rivista{" + "codiceISBN='" + codiceISBN + '\'' + ", titolo='" + titolo + '\'' + ", annoPubblicazione="
				+ annoPubblicazione + ", numeroPagine=" + numeroPagine + ", periodicità=" + periodicità + '}';
	}
}
