package jeronimo.teste.brasilprev.facade.impl;

import jeronimo.teste.brasilprev.bean.dto.requestTO.ClientRequestTO;
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
    public void creatingNewClient(ClientRequestTO to) {
        clientService.creatingNewClient(to);
    }
}