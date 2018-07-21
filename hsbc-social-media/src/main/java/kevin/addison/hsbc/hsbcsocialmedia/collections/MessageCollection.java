package kevin.addison.hsbc.hsbcsocialmedia.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "message")
public class MessageCollection {

    @Id
    private Long id;

    private String message;

    private String username;

    private LocalDate createdOn;

}
