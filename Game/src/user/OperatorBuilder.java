package user;

import app.utils.GeneralFactory;
import interfaces.UserBuilder;

public class OperatorBuilder implements UserBuilder {
    private String name;
    private String nick;
    private String password;
    private GeneralFactory factory;
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setNick(String nick) {
        this.nick = nick;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFactory(GeneralFactory factory){
        this.factory = factory;
    }
    @Override
    public User build() throws InstantiationException {
        return new Operator(this.name,this.nick,this.password,this.factory);
    }
}
