package pl.coderslab.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.coderslab.persistence.entities.Book;
import pl.coderslab.persistence.entities.Publisher;

@Component
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;


    public void delete(Book book) {
        if (!entityManager.contains(book)) {
            book = entityManager.merge(book);
        }
        entityManager.remove(book);
    }

    
    public void persist(Book book) {
        entityManager.persist(book);
    }

    
    public void update(Book book) {
        entityManager.merge(book);
    }

    
    public Book find(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b").getResultList();
    }

    public List<Book> findAllWithAnyPublisher() {
        return entityManager.createQuery("SELECT b FROM Book b JOIN Publisher p").getResultList();
    }

    public List<Book> findByPublisher(Publisher publisher) {
        return entityManager.createQuery("SELECT b FROM Book b JOIN Publisher p where p = :publisher").getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager.createQuery("SELECT b FROM Book b JOIN FETCH b.authors WHERE b.rating = :rating").setParameter("rating", rating).getResultList();
    }


}
