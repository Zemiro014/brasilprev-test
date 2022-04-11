package jeronimo.teste.brasilprev.beans.requestTO;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RoleJwtRequestTO implements Serializable {

    @NotEmpty @NotNull @Min(4)
    private String role;

    @Schema(description = "Represent the customer role. Valid roles: user, admin and dev", required = true, example = "user")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}