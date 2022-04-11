package jeronimo.teste.brasilprev.beans.responseTO;

import java.io.Serializable;

public class JwtResponseTO implements Serializable {
    private String token;
    private boolean status;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
