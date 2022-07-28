package pl.coderslab.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.coderslab.persistence.entities.Publisher;
import pl.coderslab.persistence.entities.Publisher;

@Component
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void delete(Publisher publisher) {
        if (!entityManager.contains(publisher)) {
            publisher = entityManager.merge(publisher);
        }
        entityManager.remove(publisher);
    }


    public void persist(Publisher publisher) {
        entityManager.persist(publisher);
    }


    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }


    public Publisher find(Long id) {
        return entityManager.find(Publisher.class, id);
    }

    public List<Publisher> findAll() {
        return entityManager.createQuery("SELECT p FROM Publisher p").getResultList();
    }

}
