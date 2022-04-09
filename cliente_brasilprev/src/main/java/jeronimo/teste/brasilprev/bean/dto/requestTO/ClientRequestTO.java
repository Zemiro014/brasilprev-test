package jeronimo.teste.brasilprev.bean.dto.requestTO;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

public class ClientRequestTO implements Serializable
{
    private String id;
    private String clientName;
    private String cpf;

    @OneToOne
    @JoinColumn(name = "adress_id")
    private AdressRequestTO adress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AdressRequestTO getAdress() {
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

    public void setAdress(AdressRequestTO adress) {
        this.adress = adress;
    }
}