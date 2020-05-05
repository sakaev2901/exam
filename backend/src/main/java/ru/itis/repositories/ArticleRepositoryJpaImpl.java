package ru.itis.repositories;

import org.springframework.stereotype.Component;
import ru.itis.models.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component // для того чтобы заинжектить в нужное поле с аннотацией Autowired
public class ArticleRepositoryJpaImpl implements ArticleRepository{

    @PersistenceContext
    private EntityManager entityManager;

//    @Transactional
//    здесь тоже мой косяк. без этой аннотацией у тебя данные не закоммитятся в бд
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
