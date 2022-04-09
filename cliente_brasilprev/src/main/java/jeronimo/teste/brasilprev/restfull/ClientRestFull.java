package jeronimo.teste.brasilprev.restfull;

import jeronimo.teste.brasilprev.bean.dto.requestTO.ClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.facade.api.ClientFacadeApi;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientRestFull {
    @Inject
    ClientFacadeApi facadeApi;


    @GET
    public Response findAllClients(){
        List<ClientResponseTO> clients = facadeApi.findAllClients();
        return Response.ok().entity(clients).build();
    }

    @Transactional
    @POST Response creatingNewClient(ClientRequestTO to){
        facadeApi.creatingNewClient(to);
        return Response.ok().status(Response.Status.CREATED).build();
    }
}