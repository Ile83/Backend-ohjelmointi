package fi.heusala.Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.heusala.Bookstore.domain.AppUser;
import fi.heusala.Bookstore.domain.AppUserRepository;
import fi.heusala.Bookstore.domain.Book;
import fi.heusala.Bookstore.domain.BookRepository;
import fi.heusala.Bookstore.domain.Category;
import fi.heusala.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean // tämä puuttui, mutta en tiedä mitä se tekee (ajaa pavun sovelluksen
			// käynnistyessä)

	public CommandLineRunner createDemoData(BookRepository bookRepository, CategoryRepository categoryRepository,
			AppUserRepository urepository) {
		return (args) -> {
			System.out.println("Luodaan demodataa H2-kantaan");

			Category category1 = new Category("Dekkari");
			Category category2 = new Category("Scifi");
			Category category3 = new Category("Fantasia");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			// h2-kanta on tietokanta, joka on käytössä
			// tallennetaan muutama kirja Private string title, author, int publicationYear,
			// String isbn, double price
			bookRepository.save(new Book("Kirja1 ", "Kirjailija Kirjoittaja1", 2001, "ISBN1", 11, category1));
			bookRepository.save(new Book("Kirja2 ", "Kirjailija Kirjoittaja2", 2002, "ISBN2", 12, category2));
			bookRepository.save(new Book("Kirja3 ", "Kirjailija Kirjoittaja3", 2003, "ISBN3", 13, category3)); // kehitysvaiheessa,
			// mutta ei
			// tuotannossa

			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$10$k3dXqAiLCXzJeMz7rXKH0OgqMnSwu6/SeLej2jSrrlAJcpAxrwZ3u", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$1AcJdbfKMbL9.9e8JA1TyOWChGUJAwftbvDSQBdX0R3oodOv9dyuG",
					"ADMIN");

			urepository.save(user1);
			urepository.save(user2);

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
