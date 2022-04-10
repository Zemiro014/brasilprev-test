package jeronimo.teste.brasilprev.service.api;

import jeronimo.teste.brasilprev.bean.dto.requestTO.CreateClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.requestTO.UpdateClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.responseTO.ClientResponseTO;

import java.util.List;

public interface ClientServiceApi {
    List<ClientResponseTO> findAllClients();

    void creatingNewClient(CreateClientRequestTO to);

    ClientResponseTO findClientById(String clientId);

    void updateClient(String clientId, UpdateClientRequestTO to);
}
