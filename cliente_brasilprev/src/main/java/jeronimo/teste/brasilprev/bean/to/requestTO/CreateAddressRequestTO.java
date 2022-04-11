package jeronimo.teste.brasilprev.bean.to.requestTO;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateAddressRequestTO implements Serializable {

    @NotNull @NotEmpty
    private String street;

    @NotNull @NotEmpty
    private String number;

    @NotNull @NotEmpty
    private String zipCode;

    @NotNull @NotEmpty
    private String city;

    @NotNull @NotEmpty
    private String state;

    @NotNull @NotEmpty
    private String country;

    @Schema(description = "Customer street", required = true, example = "Independência")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Schema(description = "Customer residencial number", required = true, example = "815")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Schema(description = "Customer zipcode", required = true, example = "1930001")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Schema(description = "Customer city", required = true, example = "São Leopoldo")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Schema(description = "Customer state", required = true, example = "RS")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Schema(description = "Customer country", required = true, example = "Brasil")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
