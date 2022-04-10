package jeronimo.teste.brasilprev.service.impl;

import com.google.common.base.Strings;
import jeronimo.teste.brasilprev.bean.dto.requestTO.CreateClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.requestTO.UpdateAddressTO;
import jeronimo.teste.brasilprev.bean.dto.requestTO.UpdateClientRequestTO;
import jeronimo.teste.brasilprev.bean.dto.requestTO.UpdateClientTO;
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
    public void creatingNewClient(CreateClientRequestTO to) {
        Client clientEntity = convertRequestToEntity(to);
        clientDaoApi.create(clientEntity);
    }

    @Override
    public ClientResponseTO findClientById(String clientId) {
        Client clientEntity = clientDaoApi.findById(clientId);
        return convertEntityToResponse(clientEntity);
    }

    @Override
    public void updateClient(String clientId, UpdateClientRequestTO to) {
       Client clientEntity = clientDaoApi.findById(clientId);
       clientDaoApi.update(updateClientInformation(clientEntity, to));
    }

    private Client updateClientInformation(Client clientEntity, UpdateClientRequestTO to) {
        UpdateClientTO updateClientTO = to.getNewBaseInformation();
        clientEntity.setClientName(Strings.isNullOrEmpty(updateClientTO.getClientName()) ? clientEntity.getClientName() : updateClientTO.getClientName());
        clientEntity.setCpf(Strings.isNullOrEmpty(updateClientTO.getCpf()) ? clientEntity.getCpf() : updateClientTO.getCpf());

        UpdateAddressTO addressTO = to.getNewAddressesInformation();
        clientEntity.getAdress().setCity(Strings.isNullOrEmpty(addressTO.getCity()) ? clientEntity.getAdress().getCity() : addressTO.getCity());
        clientEntity.getAdress().setCountry(Strings.isNullOrEmpty(addressTO.getCountry()) ? clientEntity.getAdress().getCountry() : addressTO.getCountry());
        clientEntity.getAdress().setNumber(Strings.isNullOrEmpty(addressTO.getNumber()) ? clientEntity.getAdress().getNumber() : addressTO.getNumber());
        clientEntity.getAdress().setState(Strings.isNullOrEmpty(addressTO.getState()) ? clientEntity.getAdress().getState() : addressTO.getState());
        clientEntity.getAdress().setStreet(Strings.isNullOrEmpty(addressTO.getStreet()) ? clientEntity.getAdress().getStreet() : addressTO.getStreet());
        clientEntity.getAdress().setZipCode(Strings.isNullOrEmpty(addressTO.getZipCode()) ? clientEntity.getAdress().getZipCode() : addressTO.getZipCode());
                return clientEntity;
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

    private Client convertRequestToEntity(CreateClientRequestTO createClientRequestTO){
        Client entity = new Client();
        entity.setClientName(createClientRequestTO.getClientName());
        entity.setCpf(createClientRequestTO.getCpf());

        Address address = new Address();
        address.setCity(createClientRequestTO.getAdress().getCity());
        address.setCountry(createClientRequestTO.getAdress().getCountry());
        address.setState(createClientRequestTO.getAdress().getState());
        address.setNumber(createClientRequestTO.getAdress().getNumber());
        address.setStreet(createClientRequestTO.getAdress().getStreet());
        address.setZipCode(createClientRequestTO.getAdress().getZipCode());
        entity.setAdress(address);

        return entity;
    }
}