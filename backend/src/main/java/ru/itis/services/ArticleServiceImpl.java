package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.itis.dto.ArticleDto;
import ru.itis.models.Article;
import ru.itis.repositories.ArticleRepository;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void addArticle(ArticleDto articleDto) {
        String text = articleDto.getText();
        String slug = generateSlug();
        Article article = Article.builder()
                .title(articleDto.getTitle())
                .text(text)
                .slug(slug)
                .build();
    }

    @Override
    public Article getArticle(String id) {
        if (isSlug(id)) {
            return articleRepository.findBySlug(id);
        } else {
            return articleRepository.findById((Long.valueOf(id)));
        }
     }

    private String generateSlug() {
        return null;
    }

    private boolean isSlug(String slug) {
        return false;
    }
}
