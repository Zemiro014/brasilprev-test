package jeronimo.teste.brasilprev.exception.custom;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ClientException extends Exception implements Serializable {
    private static final long serialVersionUID = 8375061379371067867L;

    private String code;
    private String message;

    public ClientException(){}
    public ClientException(String code, Object... params){
        setCode(code);
        setMessage(this.getMessageBundleValue(code, params));
    }

    private String getMessageBundleValue(String code, Object... params){
        String message = "";
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
        if(params == null){
            message = resourceBundle.getString(code);
        }
        else{
            String pattern = resourceBundle.getString(code);
            message = MessageFormat.format(pattern, params);
        }

        return  message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
