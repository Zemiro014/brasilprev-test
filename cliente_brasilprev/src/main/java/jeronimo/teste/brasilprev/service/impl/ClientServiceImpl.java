package jeronimo.teste.brasilprev.service.impl;

import com.google.common.base.Strings;
import jeronimo.teste.brasilprev.bean.to.requestTO.CreateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.requestTO.UpdateAddressTO;
import jeronimo.teste.brasilprev.bean.to.requestTO.UpdateClientRequestTO;
import jeronimo.teste.brasilprev.bean.to.requestTO.UpdateClientTO;
import jeronimo.teste.brasilprev.bean.to.responseTO.AddressResponseTO;
import jeronimo.teste.brasilprev.bean.to.responseTO.ClientResponseTO;
import jeronimo.teste.brasilprev.bean.vo.AddressVO;
import jeronimo.teste.brasilprev.bean.vo.ClientVO;
import jeronimo.teste.brasilprev.constants.ClientExceptionConstants;
import jeronimo.teste.brasilprev.dao.api.postgres.PostgresClientDaoApi;
import jeronimo.teste.brasilprev.exception.custom.ClientException;
import jeronimo.teste.brasilprev.service.api.ClientServiceApi;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientServiceImpl implements ClientServiceApi {

    @Inject
    private PostgresClientDaoApi clientDaoApi;

    @Override
    public List<ClientResponseTO> findAllClients() {
        List<ClientVO> clientVOS = clientDaoApi.findAll();
        return clientVOS.stream()
                .map(this::convertVoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void creatingNewClient(CreateClientRequestTO to) {
        clientDaoApi.create(convertRequestToVo(to));
    }

    @Override
    public ClientResponseTO findClientById(String clientId , JsonWebToken jwt) throws ClientException {
        ClientVO clientVO= clientDaoApi.findById(clientId);

        String clientFullName = jwt.getClaim(Claims.full_name.name());
        String clientEmail = jwt.getClaim("email");
        Object[] roles = jwt.getGroups().toArray();
        String role = Arrays.stream(roles).findFirst().get().toString();

        if(clientVO == null)
            throw new ClientException(ClientExceptionConstants.ERROR_CUSTOMER_NOT_FOUND, clientId);

        if(role.equalsIgnoreCase("user"))
            if(!clientVO.getEmail().equalsIgnoreCase(clientEmail) || !clientVO.getClientName().equalsIgnoreCase(clientFullName))
                throw new ClientException(ClientExceptionConstants.ERROR_CUSTOMER_NOT_AUTHORIZED_TO_HANDLE_ACCOUNT, clientEmail);
        return convertVoToResponse(clientVO);
    }

    @Override
    public void updateClient(String clientId, UpdateClientRequestTO to, JsonWebToken jwt) throws ClientException {
       ClientVO clientVO = clientDaoApi.findById(clientId);

        String clientFullName = jwt.getClaim(Claims.full_name.name());
        String clientEmail = jwt.getClaim("email");
        Object[] roles = jwt.getGroups().toArray();
        String role = Arrays.stream(roles).findFirst().get().toString();

        if(clientVO == null)
            throw new ClientException(ClientExceptionConstants.ERROR_CUSTOMER_NOT_FOUND, clientId);

        if(role.equalsIgnoreCase("user"))
            if(!clientVO.getEmail().equalsIgnoreCase(clientEmail) || !clientVO.getClientName().equalsIgnoreCase(clientFullName))
                throw new ClientException(ClientExceptionConstants.ERROR_CUSTOMER_NOT_AUTHORIZED_TO_HANDLE_ACCOUNT, clientEmail);
       clientDaoApi.update(updateClientInformation(clientVO, to));
    }

    private ClientVO updateClientInformation(ClientVO clientVO, UpdateClientRequestTO to) {
        UpdateClientTO updateClientTO = to.getNewBaseInformation();
        clientVO.setClientName(Strings.isNullOrEmpty(updateClientTO.getClientName()) ? clientVO.getClientName() : updateClientTO.getClientName());
        clientVO.setCpf(Strings.isNullOrEmpty(updateClientTO.getCpf()) ? clientVO.getCpf() : updateClientTO.getCpf());
        clientVO.setEmail(Strings.isNullOrEmpty(updateClientTO.getEmail()) ? clientVO.getEmail() : updateClientTO.getEmail());
        UpdateAddressTO addressTO = to.getNewAddressesInformation();
        clientVO.getAdress().setCity(Strings.isNullOrEmpty(addressTO.getCity()) ? clientVO.getAdress().getCity() : addressTO.getCity());
        clientVO.getAdress().setCountry(Strings.isNullOrEmpty(addressTO.getCountry()) ? clientVO.getAdress().getCountry() : addressTO.getCountry());
        clientVO.getAdress().setNumber(Strings.isNullOrEmpty(addressTO.getNumber()) ? clientVO.getAdress().getNumber() : addressTO.getNumber());
        clientVO.getAdress().setState(Strings.isNullOrEmpty(addressTO.getState()) ? clientVO.getAdress().getState() : addressTO.getState());
        clientVO.getAdress().setStreet(Strings.isNullOrEmpty(addressTO.getStreet()) ? clientVO.getAdress().getStreet() : addressTO.getStreet());
        clientVO.getAdress().setZipCode(Strings.isNullOrEmpty(addressTO.getZipCode()) ? clientVO.getAdress().getZipCode() : addressTO.getZipCode());
        return clientVO;
    }

    private ClientResponseTO convertVoToResponse(ClientVO clientVO){
        ClientResponseTO clientResponseTO = new ClientResponseTO();
        clientResponseTO.setClientName(clientVO.getClientName());
        clientResponseTO.setCpf(clientVO.getCpf());
        clientResponseTO.setId(clientVO.getId());
        clientResponseTO.setEmail(clientVO.getEmail());
        AddressResponseTO addressResponseTO = new AddressResponseTO();
        addressResponseTO.setId(clientVO.getAdress().getId());
        addressResponseTO.setCity(clientVO.getAdress().getCity());
        addressResponseTO.setCountry(clientVO.getAdress().getCountry());
        addressResponseTO.setState(clientVO.getAdress().getState());
        addressResponseTO.setNumber(clientVO.getAdress().getNumber());
        addressResponseTO.setStreet(clientVO.getAdress().getStreet());
        addressResponseTO.setZipCode(clientVO.getAdress().getZipCode());
        clientResponseTO.setAdress(addressResponseTO);

        return clientResponseTO;
    }

    private ClientVO convertRequestToVo(CreateClientRequestTO createClientRequestTO){
        ClientVO clientVO = new ClientVO();
        clientVO.setClientName(createClientRequestTO.getClientName());
        clientVO.setCpf(createClientRequestTO.getCpf());
        clientVO.setEmail(createClientRequestTO.getEmail());
        AddressVO addressVO = new AddressVO();
        addressVO.setCity(createClientRequestTO.getAdress().getCity());
        addressVO.setCountry(createClientRequestTO.getAdress().getCountry());
        addressVO.setState(createClientRequestTO.getAdress().getState());
        addressVO.setNumber(createClientRequestTO.getAdress().getNumber());
        addressVO.setStreet(createClientRequestTO.getAdress().getStreet());
        addressVO.setZipCode(createClientRequestTO.getAdress().getZipCode());
        clientVO.setAdress(addressVO);
        return clientVO;
    }
}