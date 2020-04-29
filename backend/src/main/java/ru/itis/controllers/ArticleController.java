package ru.itis.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.services.ArticleService;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article/show/{slug}")
    public ModelAndView getPage(@PathVariable("slug") String slug) {
        ModelAndView modelAndView = new ModelAndView("article");
        modelAndView.addObject("article", articleService.getArticle(slug));
        return modelAndView;
    }
}
