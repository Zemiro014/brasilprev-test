package jeronimo.teste.brasilprev.restfull;

import jeronimo.teste.brasilprev.bean.to.requestTO.CreateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.requestTO.UpdateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.exception.custom.ClientException;
import jeronimo.teste.brasilprev.facade.api.ClientFacadeApi;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "Customer", description = "In this module there are EndPoints that managments customer")
@Path("clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientRestFull {
    @Inject
    ClientFacadeApi facadeApi;


    @GET
    @Operation(
	summary = "All customer",
	description = "Get all customer in system"
)
    public Response findAllClients(){
        List<ClientResponseTO> clients = facadeApi.findAllClients();
        return Response.ok().entity(clients).build();
    }

    @Operation(
            summary = "New Customer",
            description = "Allow creating new customer in system"
    )
    @POST
    public Response creatingNewClient(CreateClientRequestTO to){
        facadeApi.creatingNewClient(to);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @Operation(
            summary = "Specific customer",
            description = "Allow searching a specific customer in system informing a valid id "
    )
    @Path("/{clientId}")
    @GET
    public Response findClientById(@PathParam("clientId") String clientId) throws ClientException {
        ClientResponseTO clientResponseTO = facadeApi.findClientById(clientId);
        return Response.ok().entity(clientResponseTO).build();
    }

    @Operation(
            summary = "Update Customer",
            description = "Allow updating customer information in system"
    )
    @Path("/{clientId}")
    @PUT
    public Response updateClient(@PathParam("clientId") String clientId, UpdateClientRequestTO to) throws ClientException {
        facadeApi.updateClient(clientId, to);
        return Response.ok().build();
    }
}