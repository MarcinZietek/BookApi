package pl.coderslab.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.coderslab.persistence.entities.Person;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;


    public void delete(Person person) {
        if (!entityManager.contains(person)) {
            person = entityManager.merge(person);
        }
        entityManager.remove(person);
    }


    public void persist(Person person) {
        entityManager.persist(person);
    }


    public void update(Person person) {
        entityManager.merge(person);
    }


    public Person find(Long id) {
        return entityManager.find(Person.class, id);
    }

}
