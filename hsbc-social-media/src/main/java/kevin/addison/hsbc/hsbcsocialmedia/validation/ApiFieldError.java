package kevin.addison.hsbc.hsbcsocialmedia.validation;

import lombok.Data;

@Data
public class ApiFieldError {
    private String field;
    private String code;
    private String message;
    private Object rejectedValue;

    public ApiFieldError(String field, String code, Object rejectedValue, String message) {
        setCode(code);
        setField(field);
        setRejectedValue(rejectedValue);
        setMessage(message);
    }
}
