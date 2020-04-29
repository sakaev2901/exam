package ru.itis.repositories;

import org.springframework.stereotype.Component;
import ru.itis.models.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ArticleRepositoryJpaImpl implements ArticleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }

    public Article findById(Long id) {
        return (Article) entityManager.createQuery("select c from Article c where c.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    public Article findBySlug(String slug) {
        return (Article) entityManager.createQuery("select c from Article c where c.slug = :slug")
                .setParameter("slug", slug)
                .getSingleResult();
    }
}
