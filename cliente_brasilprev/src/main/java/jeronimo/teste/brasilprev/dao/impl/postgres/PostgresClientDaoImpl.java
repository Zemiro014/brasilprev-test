package jeronimo.teste.brasilprev.dao.impl.postgres;

import org.json.JSONObject;
import jeronimo.teste.brasilprev.dao.api.postgres.PostgresClientDaoApi;
import jeronimo.teste.brasilprev.entities.Address;
import jeronimo.teste.brasilprev.entities.Client;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.*;

@ApplicationScoped
public class PostgresClientDaoImpl implements PostgresClientDaoApi {

//    @Inject
//    ClientRepository clientRepository;
//
//    @Inject
//    AddresRepository addresRepository;

    @Override
    @Transactional
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
        Optional<Client> optional = Client.findByIdOptional(id);
        return optional.orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Client> findAll() {
        return Client.findAll().list();
    }

    @Override
    @Transactional
    public void update(Client entity) {
        Map<String, Object> addressParams = new HashMap<>();
        addressParams.put("city", entity.getAdress().getCity());
        addressParams.put("country", entity.getAdress().getCountry());
        addressParams.put("number", entity.getAdress().getNumber());
        addressParams.put("state", entity.getAdress().getState());
        addressParams.put("street", entity.getAdress().getStreet());
        addressParams.put("zipcode", entity.getAdress().getZipCode());
        addressParams.put("id", entity.getAdress().getId());
        Address.update("city = :city , country = :country , number = :number , state = :state , street = :street , zipcode = :zipcode  where id = :id", addressParams);

        Map<String, Object> clientParams = new HashMap<>();
        clientParams.put("clientname", entity.getClientName());
        clientParams.put("cpf", entity.getCpf());
        clientParams.put("id", entity.getId());
        Client.update("clientname = :clientname , cpf = :cpf where id = :id", clientParams);
    }
}
