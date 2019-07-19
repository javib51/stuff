package orcom.github.javib51.quickstart.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import orcom.github.javib51.quickstart.GreetingResource;
import orcom.github.javib51.quickstart.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Inject
    EntityManager entityManager;

    private static final Logger log = LoggerFactory.getLogger(GreetingResource.class.getName());

    public Person findByName(String name) {
        return find("name", name).firstResult();
    }


    public void deleteStefs() {
        delete("name", "Stef");
    }

    @Transactional
    public void create(Person person) {
        try {
            //Here I use the persistAndFlush() shorthand method on a Panache repository to persist to database then flush the changes.
            persistAndFlush(person);
        } catch (PersistenceException pe) {

            log.error("Unable to create the parameter", pe);
            //in case of error, I save it to disk
            // diskPersister.save(person);
        }
    }
}