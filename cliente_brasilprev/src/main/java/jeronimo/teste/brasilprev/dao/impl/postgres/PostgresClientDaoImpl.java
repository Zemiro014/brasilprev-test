package jeronimo.teste.brasilprev.dao.impl.postgres;

import jeronimo.teste.brasilprev.dao.api.postgres.PostgresClientDaoApi;
import jeronimo.teste.brasilprev.entities.Address;
import jeronimo.teste.brasilprev.entities.Client;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PostgresClientDaoImpl implements PostgresClientDaoApi {
    @Override
    public void create(Client clientEntity) {
        clientEntity.setId(UUID.randomUUID().toString());
        clientEntity.getAdress().setId(UUID.randomUUID().toString());
        Address addressEntity = clientEntity.getAdress();
        addressEntity.persist();
        clientEntity.persist();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Client findById(String id) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public void update(Client entity) {

    }
}
