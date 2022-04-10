package jeronimo.teste.brasilprev.exception.handler;

import jeronimo.teste.brasilprev.bean.to.responseTO.ResponseTO;
import jeronimo.teste.brasilprev.exception.custom.ClientException;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ClientExceptionHandler implements ExceptionMapper<ClientException> {
    @Override
    public Response toResponse(ClientException exception) {

        ResponseTO responseTO = new ResponseTO();
        JSONObject json = new JSONObject();
        json.put("code", exception.getCode());
        json.put("message", exception.getMessage());
        responseTO.setJson(json.toString());
        responseTO.setStatus(false);
        return Response.status(Response.Status.BAD_REQUEST).entity(responseTO).build();
    }
}
