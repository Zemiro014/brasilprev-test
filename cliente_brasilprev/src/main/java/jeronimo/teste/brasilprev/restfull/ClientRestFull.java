package jeronimo.teste.brasilprev.restfull;

import jeronimo.teste.brasilprev.bean.to.requestTO.CreateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.requestTO.UpdateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.exception.custom.ClientException;
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
    public Response findClientById(@PathParam("clientId") String clientId) throws ClientException {
        ClientResponseTO clientResponseTO = facadeApi.findClientById(clientId);
        return Response.ok().entity(clientResponseTO).build();
    }

    @Path("/{clientId}")
    @PUT
    public Response updateClient(@PathParam("clientId") String clientId, UpdateClientRequestTO to) throws ClientException {
        facadeApi.updateClient(clientId, to);
        return Response.ok().build();
    }
}