package jeronimo.teste.brasilprev.service.impl;


import jeronimo.teste.brasilprev.bean.dto.requestTO.ClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.responseTO.AddressResponseTO;
import jeronimo.teste.brasilprev.bean.dto.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.dao.api.postgres.PostgresClientDaoApi;
import jeronimo.teste.brasilprev.entities.Address;
import jeronimo.teste.brasilprev.entities.Client;
import jeronimo.teste.brasilprev.service.api.ClientServiceApi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientServiceImpl implements ClientServiceApi {

    @Inject
    private PostgresClientDaoApi clientDaoApi;

    @Override
    public List<ClientResponseTO> findAllClients() {
        List<Client> clients = clientDaoApi.findAll();
        return clients.stream()
                .map(this::convertEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void creatingNewClient(ClientRequestTO to) {
        Client clientEntity = convertRequestToEntity(to);
        clientDaoApi.create(clientEntity);
    }

    private ClientResponseTO convertEntityToResponse(Client entity){
        ClientResponseTO clientResponseTO = new ClientResponseTO();
        clientResponseTO.setClientName(entity.getClientName());
        clientResponseTO.setCpf(entity.getCpf());
        clientResponseTO.setId(entity.getId());

        AddressResponseTO addressResponseTO = new AddressResponseTO();
        addressResponseTO.setId(entity.getAdress().getId());
        addressResponseTO.setCity(entity.getAdress().getCity());
        addressResponseTO.setCountry(entity.getAdress().getCountry());
        addressResponseTO.setState(entity.getAdress().getState());
        addressResponseTO.setNumber(entity.getAdress().getNumber());
        addressResponseTO.setStreet(entity.getAdress().getStreet());
        addressResponseTO.setZipCode(entity.getAdress().getZipCode());
        clientResponseTO.setAdress(addressResponseTO);

        return clientResponseTO;
    }

    private Client convertRequestToEntity(ClientRequestTO clientRequestTO){
        Client entity = new Client();
        entity.setClientName(clientRequestTO.getClientName());
        entity.setCpf(clientRequestTO.getCpf());

        Address address = new Address();
        address.setCity(clientRequestTO.getAdress().getCity());
        address.setCountry(clientRequestTO.getAdress().getCountry());
        address.setState(clientRequestTO.getAdress().getState());
        address.setNumber(clientRequestTO.getAdress().getNumber());
        address.setStreet(clientRequestTO.getAdress().getStreet());
        address.setZipCode(clientRequestTO.getAdress().getZipCode());
        entity.setAdress(address);

        return entity;
    }
}