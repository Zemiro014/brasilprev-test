package jeronimo.teste.brasilprev.facade.api;

import jeronimo.teste.brasilprev.bean.dto.requestTO.ClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.responseTO.ClientResponseTO;

import java.util.List;

public interface ClientFacadeApi {
    List<ClientResponseTO> findAllClients();

    void creatingNewClient(ClientRequestTO to);
}
