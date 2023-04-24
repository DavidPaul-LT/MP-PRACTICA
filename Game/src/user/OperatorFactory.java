package user;

public class OperatorFactory extends UserFactory{
    public User create(String name, String nick, String password) throws InstantiationException {
        return new Operator(name,nick,password,null);
    }
}
