package kevin.addison.hsbc.hsbcsocialmedia.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "user")
public class UserCollection {

    @Id
    private Long id;

    @Indexed(unique = true)
    private String username;

    private String fistName;

    private String lastName;

    private List<String> followers;

}
