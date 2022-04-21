package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class ArticleDao {


        @PersistenceContext
        EntityManager entityManager;

        public Article saveArticle(Article article) {
            entityManager.persist(article);
            return article;
        }

        public Article findById(long id) {
            return entityManager.find(Article.class, id);
        }

        public void update(Article article) {
            entityManager.merge(article);
        }

        public void delete(long id) {
            entityManager.remove(entityManager.contains(findById(id)) ?
                    findById(id) : entityManager.merge(findById(id)));
        }

        public List<Article> findAll(){
            return entityManager.createQuery("select b from Article b").getResultList();
        }


}
