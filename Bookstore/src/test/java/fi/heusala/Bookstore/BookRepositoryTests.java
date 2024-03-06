package fi.heusala.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.heusala.Bookstore.domain.BookRepository;
import fi.heusala.Bookstore.domain.Book;

@DataJpaTest
public class BookRepositoryTests {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void FindAll() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        assertThat(books).hasSize(3);

    }

    @Test
    public void FindOne() {
        Optional<Book> book = bookRepository.findById((long) 1);
        assertThat(book.get().getTitle()).isEqualTo("Kirja1 ");
    }

    @Test
    public void createBook() {
        Book book = new Book("testi", "testi", 2020, "testi", 20.0, null);
        bookRepository.save(book);
        List<Book> books = (List<Book>) bookRepository.findAll();
        assertThat(books).hasSize(4);
    }

    @Test
    public void deleteBook() {
        bookRepository.deleteById((long) 1);
        List<Book> books = (List<Book>) bookRepository.findAll();
        assertThat(books).hasSize(2);
    }

    @Test
    public void updateBook() {
        Book book = new Book("testi", "testi", 2020, "testi", 20.0, null);
        bookRepository.save(book);
        List<Book> books = (List<Book>) bookRepository.findAll();
        assertThat(books).hasSize(4);
        book = bookRepository.findById((long) 4).get();
        book.setTitle("testi2");
        bookRepository.save(book);
        books = (List<Book>) bookRepository.findAll();
        assertThat(books).hasSize(4);
        assertThat(books.get(3).getTitle()).isEqualTo("testi2"); // Tämä ei ole hyvä tapa testata, mutta en keksi
                                                                 // parempaa, testaa useita asioita kerralla.

    }

}

// How to kill process in Windows?

// Go to cmd ->

// netstat -ano | find "8080"

// taskkill /F /PID xxxx

// , where xxxx is process number found with netstat