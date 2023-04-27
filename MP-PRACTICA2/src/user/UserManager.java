package user;

import interfaces.Factory;
import storage.Storage;

import java.util.HashSet;


public class UserManager implements Factory {
    private static final String USER = "User:";
    private static final String CLIENTS = "Client Set";
    private static final String OPERATORS = "Operator Set";
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
    public void addInClientSet(String userNick){
        if ((!(userStorage.getValue(CLIENTS) instanceof HashSet<?>))){
            HashSet<String> clientSet = new HashSet<>();
            clientSet.add(userNick);
            userStorage.setValue(CLIENTS,clientSet);
        }else {
            HashSet<String> clientSet = (HashSet<String>) userStorage.getValue(CLIENTS);
            clientSet.add(userNick);
            userStorage.setValue(CLIENTS,clientSet);
        }
    }
    public void addInOperatorSet(String userNick){
        if ((!(userStorage.getValue(OPERATORS) instanceof HashSet<?>))){
            HashSet<String> operatorSet = new HashSet<>();
            operatorSet.add(userNick);
            userStorage.setValue(OPERATORS,operatorSet);
        }else {
            HashSet<String> operatorSet = (HashSet<String>) userStorage.getValue(OPERATORS);
            operatorSet.add(userNick);
            userStorage.setValue(OPERATORS,operatorSet);
        }
    }
    public User getUser(String nickName) {
        return (User) userStorage.getValue(USER + nickName);
    }
    public Boolean isUserBaned(String userNick){
        HashSet<String> bannedClients = (HashSet<String>) this.userStorage.getValue("Banned clients");
        return bannedClients.contains(userNick);
    }
    public boolean checkUser(String nickName, String password) {
        User userToCheck = (User) userStorage.getValue(USER + nickName);
        return (userToCheck != null && userToCheck.getPassword().equals(password));
    }
}
