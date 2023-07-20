package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "riviste")
public class Rivista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codiceISBN")
	private String codiceISBN;

	@Column(name = "titolo")
	private String titolo;

	@Column(name = "numero")
	private int numero;

	@Column(name = "periodicita")
	private String periodicita;

	// Costruttori
	public Rivista() {
	}

	public Rivista(String codiceISBN, String titolo, int numero, String periodicita) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.numero = numero;
		this.periodicita = periodicita;
	}

	// Getter e Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(String periodicita) {
		this.periodicita = periodicita;
	}
}
