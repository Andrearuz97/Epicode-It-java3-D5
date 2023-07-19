package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "elementi_catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ElementoCatalogo {
	@Id
	private String codiceISBN;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;

	public ElementoCatalogo() {
	}

	public ElementoCatalogo(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
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

	@Override
	public String toString() {
		return "ElementoCatalogo{" + "codiceISBN='" + codiceISBN + '\'' + ", titolo='" + titolo + '\''
				+ ", annoPubblicazione=" + annoPubblicazione + ", numeroPagine=" + numeroPagine + '}';
	}
}
