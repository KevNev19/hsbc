package kevin.addison.hsbc.hsbcsocialmedia.validation;

import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;

public interface Predicate {
    boolean matches(Message message, Integer id);
}
