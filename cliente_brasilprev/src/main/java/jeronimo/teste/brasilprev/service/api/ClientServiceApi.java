package jeronimo.teste.brasilprev.service.api;

import jeronimo.teste.brasilprev.bean.to.requestTO.CreateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.requestTO.UpdateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.exception.custom.ClientException;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;

public interface ClientServiceApi {
    List<ClientResponseTO> findAllClients();

    void creatingNewClient(CreateClientRequestTO to);

    ClientResponseTO findClientById(String clientId, JsonWebToken jwt) throws ClientException;

    void updateClient(String clientId, UpdateClientRequestTO to, JsonWebToken jwt) throws ClientException;
}
