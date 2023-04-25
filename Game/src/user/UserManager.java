package user;

import interfaces.Factory;
import storage.Storage;

import java.util.HashSet;


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
        HashSet<String> clientSet = (HashSet<String>) userStorage.getValue("Client Set");
        clientSet.remove(userNick);
        HashSet<String> operatorSet = (HashSet<String>) userStorage.getValue("Operator Set");
        operatorSet.remove(userNick);
    }

    public User getUser(String nickName) {
        return (User) userStorage.getValue(USER + nickName);
    }

    public boolean checkUser(String nickName, String password) {
        User userToCheck = (User) userStorage.getValue(USER + nickName);
        return (userToCheck != null && userToCheck.getPassword().equals(password));
    }
}
