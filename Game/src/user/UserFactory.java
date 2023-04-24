package user;

import interfaces.Factory;
import storage.Storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserFactory implements Factory {
    protected Storage userStorage;
    private UserFactory specificFactory;
    public UserFactory(){
        this.userStorage = Storage.getInstance();
    }
    /**
     * Returns an instance of User created by a specific factory.
     * @return User
     */
    @Override
    public User create() throws InstantiationException {
        return this.specificFactory.create();
    }

    /**
     * Deletes an instance of User from storage.
     * @param u User to remove
     */
    public void delete(User u){
        HashMap<String, Map<String,User>> auxUser = (HashMap<String, Map<String, User>>) userStorage.getValue("Users");
        auxUser.get("Clients").remove(u.getName());
        auxUser.get("Operators").remove(u.getName());
    }
    public void setSpecificFactory(ClientFactory specificFactory) {
        this.specificFactory = specificFactory;
    }

    public User getUser(String nickName) {
        return (User) userStorage.getValue("Users:" + nickName);
    }

    public boolean checkUser(String nickName, String password) {
        User userToCheck = (User) userStorage.getValue("Users:" + nickName);
        return (userToCheck != null && userToCheck.getPassword().equals(password));
    }
}
