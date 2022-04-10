package jeronimo.teste.brasilprev.bean.dto.requestTO;

import java.io.Serializable;

public class CreateClientRequestTO implements Serializable
{
    private String clientName;
    private String cpf;
    private CreateAddressRequestTO adress;

    public CreateAddressRequestTO getAdress() {
        return adress;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAdress(CreateAddressRequestTO adress) {
        this.adress = adress;
    }
}