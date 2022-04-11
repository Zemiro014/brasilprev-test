package jeronimo.teste.brasilprev.bean.to.requestTO;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateClientRequestTO implements Serializable
{
    @NotNull @NotEmpty
    private String clientName;

    @NotNull @NotEmpty @CPF
    private String cpf;

    @NotNull @NotEmpty
    private CreateAddressRequestTO adress;

    @Schema(description = "Customer address", required = true)
    public CreateAddressRequestTO getAdress() {
        return adress;
    }

    @Schema(description = "Customer full name", required = true, example = "Paulo dos Santos")
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Schema(description = "Customer cpf", required = true, example = "62308576006")
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