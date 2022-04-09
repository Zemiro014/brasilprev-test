package jeronimo.teste.brasilprev.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "client_tab")
public class Client extends PanacheEntityBase {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String clientName;
    private String cpf;

    @OneToOne
    @JoinColumn(name = "adress_id")
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAdress() {
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

    public void setAdress(Address address) {
        this.address = address;
    }
}