package kevin.addison.hsbc.hsbcsocialmedia.repository;

import kevin.addison.hsbc.hsbcsocialmedia.collections.UserCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserCollection, Long> {

    UserCollection findUserByUsername(String username);

}
