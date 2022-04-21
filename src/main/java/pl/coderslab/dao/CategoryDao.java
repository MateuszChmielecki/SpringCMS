package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public Category saveAuthor(Category category) {
        entityManager.persist(category);
        return category;
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.contains(findById(id)) ?
                findById(id) : entityManager.merge(findById(id)));
    }

    public List<Category> findAll(){
        return entityManager.createQuery("select b from Category b").getResultList();
    }

}
