package fi.heusala.Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.heusala.Bookstore.domain.Book;
import fi.heusala.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean // tämä puuttui, mutta en tiedä mitä se tekee (ajaa pavun sovelluksen
			// käynnistyessä)
	public CommandLineRunner createDemoData(BookRepository bookRepository) {
		return (args) -> {
			System.out.println("Luodaan demodataa H2-kantaan"); // h2-kanta on tietokanta, joka on käytössä
			// tallennetaan muutama kirja Private string title, author, int publicationYear,
			// String isbn, double price
			bookRepository.save(new Book("Kirja1 ", "Kirjailija Kirjoittaja1", 2001, "ISBN1", 11));
			bookRepository.save(new Book("Kirja2 ", "Kirjailija Kirjoittaja2", 2002, "ISBN2", 12));
			bookRepository.save(new Book("Kirja3 ", "Kirjailija Kirjoittaja3", 2003, "ISBN3", 13)); // kehitysvaiheessa,
																									// mutta ei
																									// tuotannossa

			System.out.println("Tulostetaan demodata Iden konsoliin");

			for (Book book : bookRepository.findAll()) {
				System.out.println(book.toString()); // konsoliin ei kyllä logaudu oikeat tiedot.

				System.out.println("Kirjan tiedot: " + book.toString()); // konsoliin ei kyllä logaudu oikeat tiedot.
																			// katso application properties tiedostosta,
																			// voi ratkaista ongelman.

			}

		};

	}
}
