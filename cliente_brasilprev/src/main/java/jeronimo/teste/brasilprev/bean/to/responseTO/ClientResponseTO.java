package jeronimo.teste.brasilprev.bean.to.responseTO;

import java.io.Serializable;

public class ClientResponseTO implements Serializable {
    private String id;
    private String clientName;
    private String cpf;
    private String email;
    private AddressResponseTO adress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddressResponseTO getAdress() {
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

    public void setAdress(AddressResponseTO adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
