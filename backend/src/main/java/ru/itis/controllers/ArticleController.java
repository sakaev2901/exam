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

    @Autowired // сюда заинжектится(вставится) объект класса articleServiceImpl
    private ArticleService articleService;

    @RequestMapping("/article/show/{slug}") // {} - синтаксис для выдергивания инфы прям из урла
    public ModelAndView getPage(@PathVariable("slug") String slug ) {
        ModelAndView modelAndView = new ModelAndView("article"); // связываем с article.ftlh
        modelAndView.addObject("article", articleService.getArticle(slug)); // кидаем нужные данны для шаблонизатора
        return modelAndView;
    }
}
