package kevin.addison.hsbc.hsbcsocialmedia.validation;

import lombok.Data;

import java.util.List;

@Data
public class ApiErrorsView {
    private List<ApiFieldError> fieldErrors;
    private List<ApiGlobalError> globalErrors;

    public ApiErrorsView(List<ApiFieldError> apiFieldErrors, List<ApiGlobalError> apiGlobalErrors) {
        setFieldErrors(apiFieldErrors);
        setGlobalErrors(apiGlobalErrors);
    }
}
