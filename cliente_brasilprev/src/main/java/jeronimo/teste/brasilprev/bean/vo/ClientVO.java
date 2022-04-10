package jeronimo.teste.brasilprev.bean.vo;

import java.io.Serializable;

public class ClientVO implements Serializable {
    private String id;
    private String clientName;
    private String cpf;

    private AddressVO address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddressVO getAdress() {
        return address;
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

    public void setAdress(AddressVO address) {
        this.address = address;
    }
}
