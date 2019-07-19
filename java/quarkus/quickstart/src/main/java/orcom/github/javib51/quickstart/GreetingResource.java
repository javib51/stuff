package orcom.github.javib51.quickstart;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import orcom.github.javib51.quickstart.entity.Person;
import orcom.github.javib51.quickstart.repository.PersonRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {
    private static final Logger log = LoggerFactory.getLogger(GreetingResource.class.getName());

//    @Inject
//    EntityManager em;

    @Inject
    PersonRepository personRepository;

    @GET
    public CompletionStage<Hello> hello() {
        log.info("here I am");
        return CompletableFuture.supplyAsync(() -> new Hello("Its me"));
    }

    @GET
    @Path("count")
    public long count() {
        return personRepository.count();
    }

    @POST
    @Path("new")
    public CompletableFuture<String> newPerson() {
        return CompletableFuture.supplyAsync(this::createPerson);
    }

    public String createPerson() {
        Person person = new Person();
        person.birth = LocalDate.now();
        person.name = "Manu";
        personRepository.create(person);
        return "hey";
    }
}