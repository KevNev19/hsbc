package kevin.addison.hsbc.hsbcsocialmedia.service;

import kevin.addison.hsbc.hsbcsocialmedia.rest.model.User;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

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
        userData.put(key,newUser);

        key++;
    }
}
