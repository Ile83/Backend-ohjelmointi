package fi.heusala.Bookstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import jakarta.validation.Valid;
import fi.heusala.Bookstore.domain.Book;
import fi.heusala.Bookstore.domain.BookRepository;
import fi.heusala.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    // Näytttää kaikki kirjat
    @GetMapping("/booklist")
    public String showBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @RequestMapping("/index")
    public String hello(Model Model) {

        return "index";
    }
    // @RequestMapping("/index") onko tämä oikein vai ymmärsinkö tehtävän väärin?`
    // pitäisikö olla GetMapping? termit vielä vähän sekaisin. En myöskään luonut
    // templateen index.html tiedostoa, kun en tiennyt pitikö se jo tehdä tehtävän
    // annosta.

    @RequestMapping(value = "/add") // lisää kirja
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST) // tallentaa kirjan

    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) // poistaa kirjan
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {

        bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET) // muokkaa kirjaa
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bookRepository.findById(bookId));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }

}
