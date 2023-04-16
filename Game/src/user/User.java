package user;

import java.io.Serializable;

public abstract class User implements Serializable {
    String name;
    private String nick;
    private final int MIN_PASSWORD_LEN = 8;
    private final int MAX_PASSWORD_LEN = 12;
    private String password;
    public User(String name, String nick, String password){
        this.name = name;
        this.nick = nick;
        this.password = password;
    }

}
