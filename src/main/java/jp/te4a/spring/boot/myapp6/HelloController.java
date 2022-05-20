package jp.te4a.spring.boot.myapp6;

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
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "this is setting message");
        return "index";
    }
    @RequestMapping(value="/post", method=RequestMethod.POST)
     public ModelAndView postForm(@RequestParam("id") String id, 
    @RequestParam("title") String title,@RequestParam("writer") String writer, 
    @RequestParam("publisher") String publisher,@RequestParam("price") String price) {
         ModelAndView mv = new ModelAndView("index");
         bookService.save(new BookBean(Integer.valueOf(id), title, writer, publisher,Integer.valueOf(price)));
         StringBuffer buff = new StringBuffer();
         buff.append("<HR>");
        for(BookBean bean:bookService.findAll()) {
            buff.append("ID:" + bean.getId() + "<BR>" + "タイトル:" + bean.getTitle() + 
           "<BR>"+ "著者:" + bean.getWriter() + "<BR>" + "出版社:" + bean.getPublisher() + 
           "<BR>"+ "価格:" + bean.getPrice() + "<BR><HR>");
        }
        mv.addObject("msg", buff.toString());
        return mv;
    }
}
