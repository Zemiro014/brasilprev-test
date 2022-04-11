package jeronimo.teste.brasilprev.resources;

import jeronimo.teste.brasilprev.beans.requestTO.RoleJwtRequestTO;
import jeronimo.teste.brasilprev.beans.responseTO.JwtResponseTO;
import jeronimo.teste.brasilprev.service.JWTService;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jwt/authentication")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JwtResource {

    @Inject
    JWTService jwtService;

    @POST
    @Parameter(in = ParameterIn.HEADER, name = "Client-Name", example = "João Kleber", description = "Must be the customer full name", required = true)
    @Parameter(in = ParameterIn.HEADER, name = "Client-Email", example = "joao@gmail.com", description = "Must be the valid email of customer", required = true)
    public Response getJwt2(
            @HeaderParam("Client-Name") String clientName,
            @HeaderParam("Client-Email") String clientEmail,
            @Valid RoleJwtRequestTO to
    ){
        JwtResponseTO responseTO = jwtService.generateJwt( clientName, clientEmail, to);
        return Response.ok().entity(responseTO).build();
    }
}