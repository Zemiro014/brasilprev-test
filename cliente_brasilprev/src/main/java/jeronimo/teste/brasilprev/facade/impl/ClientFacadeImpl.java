package jeronimo.teste.brasilprev.facade.impl;

import jeronimo.teste.brasilprev.bean.to.requestTO.CreateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.requestTO.UpdateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.exception.custom.ClientException;
import jeronimo.teste.brasilprev.facade.api.ClientFacadeApi;
import jeronimo.teste.brasilprev.service.api.ClientServiceApi;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ClientFacadeImpl implements ClientFacadeApi {

    @Inject
    private ClientServiceApi clientService;

    @Override
    public List<ClientResponseTO> findAllClients() {
        return clientService.findAllClients();
    }

    @Override
    public void creatingNewClient(CreateClientRequestTO to) {
        clientService.creatingNewClient(to);
    }

    @Override
    public ClientResponseTO findClientById(String clientId, JsonWebToken jwt) throws ClientException {
        return clientService.findClientById(clientId, jwt);
    }

    @Override
    public void updateClient(String clientId, UpdateClientRequestTO to, JsonWebToken jwt) throws ClientException {
        clientService.updateClient(clientId, to, jwt);
    }
}