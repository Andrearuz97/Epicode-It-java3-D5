package model;

import java.util.Date;

public class Prestito {
	private Utente utente;
	private ElementoCatalogo elementoCatalogo;
	private Date dataInizioPrestito;
	private Date dataRestituzionePrevista;
	private Date dataRestituzioneEffettiva;

	public Prestito() {
	}

	public Prestito(Utente utente, ElementoCatalogo elementoCatalogo, Date dataInizioPrestito) {
		this.utente = utente;
		this.elementoCatalogo = elementoCatalogo;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = calculateDataRestituzionePrevista(dataInizioPrestito);
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public ElementoCatalogo getElementoCatalogo() {
		return elementoCatalogo;
	}

	public void setElementoCatalogo(ElementoCatalogo elementoCatalogo) {
		this.elementoCatalogo = elementoCatalogo;
	}

	public Date getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(Date dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public Date getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}

	public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}

	public Date getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}

	public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	private Date calculateDataRestituzionePrevista(Date dataInizioPrestito) {

		return null;
	}
}
