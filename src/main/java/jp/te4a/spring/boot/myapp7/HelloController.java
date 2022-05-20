package jp.te4a.spring.boot.myapp7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @Autowired
    BookService bookService;
    @RequestMapping("books/list")
    public String index(Model model) {
        model.addAttribute("msg", "this is setting message");
        return "books/list";
    }
    @RequestMapping(value="books/list", method=RequestMethod.POST)
    public ModelAndView postForm(@RequestParam("id") String id, 
        @RequestParam("title") String title, @RequestParam("writer") String writer, 
        @RequestParam("publisher") String publisher, @RequestParam("price") String 
        price) {
        ModelAndView mv = new ModelAndView("books/list");
        bookService.save(new BookBean(Integer.valueOf(id), title, writer, publisher, 
            Integer.valueOf(price)));
        mv.addObject("books", bookService.findAll());
        return mv;
    }
}
