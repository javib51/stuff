package orcom.github.javib51.quickstart;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class AppLiveCicle {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppLiveCicle.class.getSimpleName());

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }

}