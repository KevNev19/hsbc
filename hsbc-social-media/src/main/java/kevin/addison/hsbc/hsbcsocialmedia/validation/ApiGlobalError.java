package kevin.addison.hsbc.hsbcsocialmedia.validation;

import lombok.Data;

@Data
public class ApiGlobalError {
    private String code;

    public ApiGlobalError(String code) {
        setCode(code);
    }
}
