package jeronimo.teste.brasilprev.restfull;

import jeronimo.teste.brasilprev.bean.dto.requestTO.CreateClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.requestTO.UpdateClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.facade.api.ClientFacadeApi;

import javax.inject.Inject;
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

    @POST
    public Response creatingNewClient(CreateClientRequestTO to){
        facadeApi.creatingNewClient(to);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @Path("/{clientId}")
    @GET
    public Response findClientById(@PathParam("clientId") String clientId){
        ClientResponseTO clientResponseTO = facadeApi.findClientById(clientId);
        return Response.ok().entity(clientResponseTO).build();
    }

    @Path("/{clientId}")
    @PUT
    public Response updateClient(@PathParam("clientId") String clientId, UpdateClientRequestTO to){
        facadeApi.updateClient(clientId, to);
        return Response.ok().build();
    }
}