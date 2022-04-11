package jeronimo.teste.brasilprev.dao.impl.postgres;
import jeronimo.teste.brasilprev.bean.vo.AddressVO;
import jeronimo.teste.brasilprev.bean.vo.ClientVO;
import jeronimo.teste.brasilprev.dao.api.postgres.PostgresClientDaoApi;
import jeronimo.teste.brasilprev.entities.Address;
import jeronimo.teste.brasilprev.entities.Client;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class PostgresClientDaoImpl implements PostgresClientDaoApi {

    @Override
    @Transactional
    public void create(ClientVO clientVO) {
        clientVO.setId(UUID.randomUUID().toString());
        clientVO.getAdress().setId(UUID.randomUUID().toString());
        Client client = this.convertVoToEntity(clientVO);
        client.getAdress().persist();
        client.persist();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ClientVO findById(String id) {
        Optional<Client> optional = Client.findByIdOptional(id);
        ClientVO clientVO = null;
        if(optional.isPresent()){
            clientVO = this.convertEntityToVo(optional.get());
        }
        return clientVO;
    }

    @Override
    public List<ClientVO> findAll() {
        List<ClientVO> clientVOS = null;
        List<Client> clients = Client.listAll();
        clientVOS = clients.stream().map(this::convertEntityToVo).collect(Collectors.toList());
        return clientVOS;
    }

    @Override
    @Transactional
    public void update(ClientVO clientVO) {
        Map<String, Object> addressParams = new HashMap<>();
        addressParams.put("city", clientVO.getAdress().getCity());
        addressParams.put("country", clientVO.getAdress().getCountry());
        addressParams.put("number", clientVO.getAdress().getNumber());
        addressParams.put("state", clientVO.getAdress().getState());
        addressParams.put("street", clientVO.getAdress().getStreet());
        addressParams.put("zipcode", clientVO.getAdress().getZipCode());
        addressParams.put("id", clientVO.getAdress().getId());
        Address.update("city = :city , country = :country , number = :number , state = :state , street = :street , zipcode = :zipcode  where id = :id", addressParams);

        Map<String, Object> clientParams = new HashMap<>();
        clientParams.put("clientname", clientVO.getClientName());
        clientParams.put("cpf", clientVO.getCpf());
        clientParams.put("email", clientVO.getEmail());
        clientParams.put("id", clientVO.getId());
        Client.update("clientname = :clientname , cpf = :cpf, email = :email where id = :id", clientParams);
    }

    private ClientVO convertEntityToVo(Client entity){
        ClientVO clientVO = new ClientVO();
        clientVO.setClientName(entity.getClientName());
        clientVO.setCpf(entity.getCpf());
        clientVO.setEmail(entity.getEmail());
        clientVO.setId(entity.getId());

        AddressVO addressVO = new AddressVO();
        addressVO.setZipCode(entity.getAdress().getZipCode());
        addressVO.setState(entity.getAdress().getState());
        addressVO.setStreet(entity.getAdress().getStreet());
        addressVO.setNumber(entity.getAdress().getNumber());
        addressVO.setId(entity.getAdress().getId());
        addressVO.setCity(entity.getAdress().getCity());
        addressVO.setCountry(entity.getAdress().getCountry());
        clientVO.setAdress(addressVO);
        return  clientVO;
    }
    private Client convertVoToEntity(ClientVO clientVO){
        Client entity = new Client();
        entity.setClientName(clientVO.getClientName());
        entity.setCpf(clientVO.getCpf());
        entity.setEmail(clientVO.getEmail());
        entity.setId(clientVO.getId());

        Address address = new Address();
        address.setZipCode(clientVO.getAdress().getZipCode());
        address.setState(clientVO.getAdress().getState());
        address.setStreet(clientVO.getAdress().getStreet());
        address.setNumber(clientVO.getAdress().getNumber());
        address.setId(clientVO.getAdress().getId());
        address.setCity(clientVO.getAdress().getCity());
        address.setCountry(clientVO.getAdress().getCountry());
        entity.setAdress(address);
        return entity;
    }
}
