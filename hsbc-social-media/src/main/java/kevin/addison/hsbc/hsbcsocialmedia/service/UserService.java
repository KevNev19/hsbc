package kevin.addison.hsbc.hsbcsocialmedia.service;

import kevin.addison.hsbc.hsbcsocialmedia.rest.model.User;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@Service
public class UserService {

    private HashMap<Integer, User> userData = new HashMap<>();
    private Integer key = 1;

    public HashMap<Integer, User> getUserData() {
        return userData;
    }

    public void createUser(UserSub user) {
        User newUser = new User();
        newUser.setId(key);
        newUser.setUsername(user.getUsername());
        newUser.setFollowing(new ArrayList<>());
        userData.put(key, newUser);

        key++;
    }

    public ResponseEntity<Void> checkUserExists(Integer id) {
        if (userData.containsKey(id)) {
            return ok().build();
        } else {
            return notFound().build();
        }

    }

    public ResponseEntity<Void> followUser(Integer id, UserSub body) {
        boolean updated = false;
        for (Integer userId : userData.keySet()) {
            if (userId == id) {
                User user = userData.get(id);
                user.getFollowing().add(body.getId());
                userData.put(userId, user);
                updated = true;
            }
        }

        if (updated) {
            return ok().build();
        } else {
            return notFound().build();
        }
    }
}
