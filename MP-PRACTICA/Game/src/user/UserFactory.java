package user;

import interfaces.Factory;
import storage.Storage;

import java.io.Serializable;
import java.util.Set;

public class UserFactory implements Factory {
    private Storage userStorage;
    private ClientFactory specificFactory;


    private OperatorFactory operator;





    public UserFactory(){

        specificFactory = new ClientFactory();

        operator = new OperatorFactory();


        this.userStorage = Storage.getInstance();


        /**
         * Returns an instance of User created by a specific factory.
         * @return User
         */
    }

    @Override
    public User create() {
        return this.specificFactory.create();
    }

    /**
     * Deletes an instance of User from storage.
     * @param u User to remove
     * @return True if user was deleted and false if user was not in storage.
     */
    public Boolean delete(User u){
        Set<Serializable> users = this.userStorage.getValue("Users");
        if (users.contains(u)){
            users.remove(u);
            return true;
        }
        return false;
    }
    public void setSpecificFactory(ClientFactory specificFactory) {
        this.specificFactory = specificFactory;
    }
}
