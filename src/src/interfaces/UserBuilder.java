package src.interfaces;

import src.user.User;

public interface UserBuilder {
    public void setName(String name);
    public void setNick(String nick);
    public void setPassword(String password);
    public User build() throws InstantiationException;
}
