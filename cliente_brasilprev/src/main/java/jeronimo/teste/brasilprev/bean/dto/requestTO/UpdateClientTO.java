package jeronimo.teste.brasilprev.bean.dto.requestTO;

import java.io.Serializable;

public class UpdateClientTO implements Serializable {
    private String clientName;
    private String cpf;

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
}