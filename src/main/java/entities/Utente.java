package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente {

	@Id
	private long numeroTessera;

	private String nome;
	private String cognome;
	private LocalDate dataNascita;

	public Utente(long numeroTessera, String nome, String cognome, LocalDate dataNascita) {
		this.numeroTessera = numeroTessera;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}
}
