package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import java.awt.print.Book;
import java.util.List;
import java.util.function.Consumer;

@Controller
public class HomePageController {
    @Autowired
    private ArticleDao articleDao;

    @RequestMapping("")
    @ResponseBody
    public String home() {
        List<Article> all = articleDao.findAll();
        all.forEach(book -> System.out.println(book.getTitle()));
        return "book list";
    }

}
