package user;

import interfaces.Factory;
import storage.Storage;


public class UserFactory implements Factory {
    private static String USER = "User:";
    protected Storage userStorage;
    private UserFactory specificFactory;
    public UserFactory(){
        this.userStorage = Storage.getInstance();
    }

    /**
     * Deletes an instance of User from storage.
     * @param u User to remove
     */
    public void delete(String userNick){
        userStorage.deleteKey(USER + userNick);
    }
    public void setSpecificFactory(UserFactory specificFactory) {
        this.specificFactory = specificFactory;
    }

    public User getUser(String nickName) {
        return (User) userStorage.getValue(USER + nickName);
    }

    public boolean checkUser(String nickName, String password) {
        User userToCheck = (User) userStorage.getValue(USER + nickName);
        return (userToCheck != null && userToCheck.getPassword().equals(password));
    }
}
