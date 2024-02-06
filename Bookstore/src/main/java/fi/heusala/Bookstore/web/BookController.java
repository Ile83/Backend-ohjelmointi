package fi.heusala.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

}
