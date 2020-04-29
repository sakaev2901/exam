package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Article;

@Controller
public class ArticleUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView("upload");
        return modelAndView;
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public void addArticle(@RequestParam("title") String title, @RequestParam("text") String text) {
        System.out.println(title);
    }
}
