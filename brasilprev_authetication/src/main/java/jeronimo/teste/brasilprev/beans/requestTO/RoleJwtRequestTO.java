package jeronimo.teste.brasilprev.beans.requestTO;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class RoleJwtRequestTO implements Serializable {

    @NotEmpty @NotNull @Size(min = 3)
    private String role;

    @Schema(description = "Represent the customer role", required = true, example = "user", defaultValue = "user | admin | dev")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}