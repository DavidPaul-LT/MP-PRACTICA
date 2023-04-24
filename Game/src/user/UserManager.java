package user;

import interfaces.Factory;
import storage.Storage;


public class UserManager implements Factory {
    private static final String USER = "User:";
    protected Storage userStorage;
    public UserManager(){
        this.userStorage = Storage.getInstance();
    }

    /**
     * Deletes an instance of User from storage.
     * @param userNick User to remove
     */
    public void delete(String userNick){
        userStorage.deleteKey(USER + userNick);
    }

    public User getUser(String nickName) {
        return (User) userStorage.getValue(USER + nickName);
    }

    public boolean checkUser(String nickName, String password) {
        User userToCheck = (User) userStorage.getValue(USER + nickName);
        return (userToCheck != null && userToCheck.getPassword().equals(password));
    }
}
