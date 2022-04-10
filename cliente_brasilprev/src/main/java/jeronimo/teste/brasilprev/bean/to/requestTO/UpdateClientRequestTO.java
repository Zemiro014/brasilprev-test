package jeronimo.teste.brasilprev.bean.to.requestTO;

import java.io.Serializable;

public class UpdateClientRequestTO implements Serializable {
    private UpdateClientTO newBaseInformation;
    private UpdateAddressTO newAddressesInformation;

    public UpdateClientTO getNewBaseInformation() {
        return newBaseInformation;
    }

    public void setNewBaseInformation(UpdateClientTO newBaseInformation) {
        this.newBaseInformation = newBaseInformation;
    }

    public UpdateAddressTO getNewAddressesInformation() {
        return newAddressesInformation;
    }

    public void setNewAddressesInformation(UpdateAddressTO newAddressesInformation) {
        this.newAddressesInformation = newAddressesInformation;
    }
}
