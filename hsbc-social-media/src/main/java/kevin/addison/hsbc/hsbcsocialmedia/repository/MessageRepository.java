package kevin.addison.hsbc.hsbcsocialmedia.repository;

import kevin.addison.hsbc.hsbcsocialmedia.collections.MessageCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<MessageCollection, Long> {

    List<MessageCollection> findAllByUsernameOrderByCreatedOn(String username);

}