package orcom.github.javib51.quickstart;

import org.openapitools.api.NotFoundException;
import org.openapitools.api.impl.ItemApiServiceImpl;
import org.openapitools.model.POSTItemRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("item")
public class ItemsResource extends ItemApiServiceImpl {

    @Override
    @POST
    public Response itemPost(POSTItemRequest body, String authorization, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().build();
    }
}
