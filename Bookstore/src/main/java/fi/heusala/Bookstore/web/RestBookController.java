package fi.heusala.Bookstore.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.heusala.Bookstore.domain.Book;
import fi.heusala.Bookstore.domain.BookRepository;
import fi.heusala.Bookstore.domain.CategoryRepository;

@RestController
public class RestBookController {

    private static final Logger log = LoggerFactory.getLogger(RestBookController.class);

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        log.info("Fetching all books from db and returning them as JSON");
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getOneBook(@PathVariable Long bookId) {
        log.info("Fetching one book with id " + bookId + " from db and returning it as JSON");
        return bookRepository.findById(bookId);
    }
    // Testaa nämä postman sovelluksella
    // @PostMapping("/book")
    // Book newBook(@RequestBody Book newBook) {
    // log.info("Saving new book to db" + newBook);
    // return bookRepository.save(newBook);
}

// @PutMapping("/book/{id}")
// Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
// log.info("editBook = " + editedBook);
// log.info("edit book, id = " + id);
// editedBook.setId(id);
// log.info("editBook = " + editedBook);
// return bookRepository.save(editedBook);
// }

// }
