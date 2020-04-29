package ru.itis.services;

import ru.itis.dto.ArticleDto;
import ru.itis.models.Article;

public interface ArticleService {
    void addArticle(ArticleDto articleDto);
    Article getArticle(String id);
}
