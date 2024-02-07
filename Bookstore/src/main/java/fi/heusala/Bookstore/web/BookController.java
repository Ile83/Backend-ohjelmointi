package fi.heusala.Bookstore.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fi.heusala.Bookstore.domain.Book;
import fi.heusala.Bookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired // mikä tämä on?
    private BookRepository bookRepository;

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

    @RequestMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST) /// save ei toimi, Syntax error on token ""/save"",
                                                                  /// invalid MemberValuePairs
    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) { // By using @PathVariable annotation Spring
                                                                             // extracts id from the URI, en ymmärrä
                                                                             // tätä?

        bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }

}
