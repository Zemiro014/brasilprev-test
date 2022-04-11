package jeronimo.teste.brasilprev.resources;

import jeronimo.teste.brasilprev.beans.requestTO.RoleJwtRequestTO;
import jeronimo.teste.brasilprev.beans.responseTO.JwtResponseTO;
import jeronimo.teste.brasilprev.service.JWTService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Tag(name = "brasilprev_authentication", description = "It's the module that allows authentication")
@Path("/jwt/authentication")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JwtResource {

    @Inject
    JWTService jwtService;

    @Operation(
            summary = "Authentication",
            description = "Route that allows authentication"
    )
    @POST
    @Parameter(in = ParameterIn.HEADER, name = "Client_Name", example = "João Kleber", description = "Must be a customer full name", required = true)
    @Parameter(in = ParameterIn.HEADER, name = "Client_Email", example = "joao@gmail.com", description = "Must be a valid email of customer", required = true)
    public Response getJwt2(
            @HeaderParam("Client_Name") String clientName,
            @HeaderParam("Client_Email") String clientEmail,
            @Valid RoleJwtRequestTO to
    ){
        JwtResponseTO responseTO = jwtService.generateJwt( clientName, clientEmail, to);
        return Response.ok().entity(responseTO).build();
    }
}