package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.itis.dto.ArticleDto;
import ru.itis.models.Article;
import ru.itis.repositories.ArticleRepository;

import java.util.Date;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void addArticle(ArticleDto articleDto) {
        String text = articleDto.getText();
        String slug = generateSlug(articleDto.getText());
        Article article = Article.builder()
                .title(articleDto.getTitle())
                .text(text)
                .slug(slug)
                .build();
//        articleRepository.save(article);
//        этого тоже не было. сори

    }

    @Override
    public Article getArticle(String id) {
        // в задании сказано что статья должна возвращаться по двум урлам. /id и /slug. Поэтому метод isSlug нужен чтобы проверить
//        явлвяется ли часть после cлэша просто id или буквенным идентификатором
        if (isSlug(id)) {
            return articleRepository.findBySlug(id);
        } else {
            return articleRepository.findById((Long.valueOf(id)));
        }
     }

    private String generateSlug(String text) {
        Date date = new Date();
        text += date.toString(); // к нашему тексту прибавляем дату чтобы унифицировать
        Integer hash = text.hashCode(); // hashCode даст нам число
        String slug = "";
        // смысл этого цикла в том чтобы вычленять по цифру из нашего хэшкода прибавлять кодировку символа 'a' и обратно
        // кастить в char. Получится почти уникальный идентификатор. Но коллизии тоже могут быть
        while (hash > 0) {
            int charCode = 'a' + hash % 10;
            slug += (char)charCode;
            hash /= 10;
        }
        return slug;
    }

    private boolean isSlug(String slug) {
        // берется первый символ. Так как мы генерировали slug таким образом что он содержит только символы 'a', 'b' и тд
//        то достаточно этой проверки
        char firstChar = slug.charAt(0);
        return firstChar >= 'a';
    }
}
