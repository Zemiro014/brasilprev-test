package jeronimo.teste.brasilprev.factorObject;

import jeronimo.teste.brasilprev.bean.to.requestTO.CreateAddressRequestTO;
import jeronimo.teste.brasilprev.bean.to.requestTO.CreateClientRequestTO;

public class BuildObject {

    public CreateClientRequestTO createClientRequestTO(){
        CreateClientRequestTO clientRequestTO = new CreateClientRequestTO();
        clientRequestTO.setClientName("Sandra Armando");
        clientRequestTO.setCpf("23695918039");
        CreateAddressRequestTO addressRequestTO = new CreateAddressRequestTO();
        clientRequestTO.setAdress(addressRequestTO);
        addressRequestTO.setCity("Novo Hamburgo");
        addressRequestTO.setCountry("Brasil");
        addressRequestTO.setState("RS");
        addressRequestTO.setNumber("1870");
        addressRequestTO.setZipCode("93010003");
        addressRequestTO.setStreet("Centro");
        return clientRequestTO;
    }
}
