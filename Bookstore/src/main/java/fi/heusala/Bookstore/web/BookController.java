package fi.heusala.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping("/index")
    public String hello(Model Model) {

        return "index";
    }
    // @RequestMapping("/index") onko tämä oikein vai ymmärsinkö tehtävän väärin?`
    // pitäisikö olla GetMapping? termit vielä vähän sekaisin. En myöskään luonut
    // templateen index.html tiedostoa, kun en tiennyt pitikö se jo tehdä tehtävän
    // annosta.

}
