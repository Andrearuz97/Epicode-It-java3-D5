package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libri")
@Getter
@Setter
@NoArgsConstructor
public class Libro extends Lettura{

	private String autore;
	
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	public Libro(long isbn, String titolo, int anno, int pagine, String autore, Genere genere) {
		super(isbn, titolo, anno, pagine);
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + getIsbn() + ", titolo=" + getTitolo() + ", anno= " + getAnno() + ", pagine= " + getPagine()
				+  ", autore=" + autore + ", genere=" + genere + "]";
	}
	
	
}
	
	
	
	
	
