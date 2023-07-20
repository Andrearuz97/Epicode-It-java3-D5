package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "riviste")
@Getter
@Setter
@NoArgsConstructor
public class Rivista extends Lettura {

	private Periodicità periodicità;

	public Rivista(long isbn, String titolo, int anno, int pagine, Periodicità periodicità) {
		super(isbn, titolo, anno, pagine);
		this.periodicità = periodicità;
	}

	@Override
	public String toString() {
		return "Rivista [ISBN=" + getIsbn() + ", Titolo=" + getTitolo() + ", Anno=" + getAnno() + ", Pagine="
				+ getPagine() + ", Periodicità=" + periodicità + "]";
	}
}
