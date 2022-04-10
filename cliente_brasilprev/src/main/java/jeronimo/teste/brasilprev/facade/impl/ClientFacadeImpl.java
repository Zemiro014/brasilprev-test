package jeronimo.teste.brasilprev.facade.impl;

import jeronimo.teste.brasilprev.bean.dto.requestTO.CreateClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.requestTO.UpdateClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.facade.api.ClientFacadeApi;
import jeronimo.teste.brasilprev.service.api.ClientServiceApi;

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
    public ClientResponseTO findClientById(String clientId) {
        return clientService.findClientById(clientId);
    }

    @Override
    public void updateClient(String clientId, UpdateClientRequestTO to) {
        clientService.updateClient(clientId, to);
    }
}