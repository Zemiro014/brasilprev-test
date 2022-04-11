package jeronimo.teste.brasilprev.services;

import io.quarkus.test.junit.QuarkusTest;
import jeronimo.teste.brasilprev.bean.to.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.exception.custom.ClientException;
import jeronimo.teste.brasilprev.service.api.ClientServiceApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
public class ClientServiceTest {

    @Inject
    ClientServiceApi serviceApi;

    @Test
    public void testFindAllClientsIsNotEmpty(){
        List<ClientResponseTO> clients = serviceApi.findAllClients();
        Assertions.assertFalse(clients.isEmpty());
    }

    @Test
    public void testThrowsExceptionWhenClientNotFound(){
        Assertions.assertThrows(ClientException.class, () -> {
            ClientResponseTO client = serviceApi.findClientById("b07e0b20-b7b4-11ec-aa42-bb7fafee3cf65");
        });
    }
}
