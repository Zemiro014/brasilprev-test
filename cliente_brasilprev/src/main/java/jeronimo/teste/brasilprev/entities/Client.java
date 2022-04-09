package jeronimo.teste.brasilprev.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Client extends PanacheEntity {
    private String clientName;
    private String cpf;

    @OneToOne
    @JoinColumn(name = "adress_id")
    private Adress adress;

    public Adress getAdress() {
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

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}