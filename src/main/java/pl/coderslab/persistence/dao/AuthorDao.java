package pl.coderslab.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.coderslab.persistence.entities.Author;

@Component
@Transactional
public class AuthorDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    public void delete(Author author) {
        if (!entityManager.contains(author)) {
            author = entityManager.merge(author);
        }
        entityManager.remove(author);
    }


    public void persist(Author author) {
        entityManager.persist(author);
    }


    public void update(Author author) {
        entityManager.merge(author);
    }

    public Author find(Long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> findAll() {
        return entityManager.createQuery("SELECT a from Author a").getResultList();
    }

}
