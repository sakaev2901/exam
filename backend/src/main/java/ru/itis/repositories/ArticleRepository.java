package ru.itis.repositories;

import ru.itis.models.Article;

public interface ArticleRepository {

    void save(Article article);
    Article findById(Long id);
    Article findBySlug(String slug);
}
