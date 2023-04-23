package user;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String name;
    protected String nick;
    protected String password;
    private Boolean checkPassword(String password){
        int minPasswordLength = 8;
        int maxPasswordLength = 12;
        return minPasswordLength <= password.length() && password.length() <= maxPasswordLength;
    }
    protected User(String name, String nick, String password) throws InstantiationException {
        this.name = name;
        this.nick = nick;
        if (this.checkPassword(password)){
            this.password = password;
        }else{
            throw new InstantiationException();
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String value){
        this.name = value;
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String value) {
        this.nick = value;
    }
}
