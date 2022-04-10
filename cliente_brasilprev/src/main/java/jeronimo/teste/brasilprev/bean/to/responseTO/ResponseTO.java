package jeronimo.teste.brasilprev.bean.to.responseTO;

import java.io.Serializable;

public class ResponseTO implements Serializable {

    private String json;
    private boolean status;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
