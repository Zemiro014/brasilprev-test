package jeronimo.teste.brasilprev.bean.to.requestTO;

import java.io.Serializable;

public class UpdateClientTO implements Serializable {
    private String clientName;
    private String cpf;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}