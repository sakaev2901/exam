package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.ArticleDto;
import ru.itis.models.Article;
import ru.itis.services.ArticleService;

@Controller
public class ArticleUploadController {

    @Autowired
    private ArticleService articleService;
// закоментил это так как не успел добавить


    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView("upload");
        return modelAndView;
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public void addArticle(@RequestParam("title") String title, @RequestParam("text") String text) {
        // RequestParam связывает данные с тела запроса и нужным полем в джава
//        ArticleDto articleDto = new ArticleDto();
//        articleDto.setText(text);
//        articleDto.setTitle(title);
//        articleService.addArticle(articleDto);
        // тоже не успел
        System.out.println(title);
    }
}
