package jeronimo.teste.brasilprev.service.api;

import jeronimo.teste.brasilprev.bean.dto.requestTO.ClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.responseTO.ClientResponseTO;

import java.util.List;

public interface ClientServiceApi {
    List<ClientResponseTO> findAllClients();

    void creatingNewClient(ClientRequestTO to);
}
