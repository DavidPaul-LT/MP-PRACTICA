package user;

import app_utils.GeneralFactory;
import battle.BattleRequest;
import storage.Storage;

import java.util.HashSet;
import java.util.Set;

public class Operator extends User{
    private Storage storage;
    private GeneralFactory mainFactory;

    public Operator(String name, String nick, String password, GeneralFactory mainFactory) throws InstantiationException {
        super(name, nick, password);
        storage = Storage.getInstance();
        this.mainFactory = mainFactory;
    }

    public void editEntity(String category, String name){}
    public void validateBattleRequest(BattleRequest b){
        UserManager userManager = new UserManager();
        Client user = (Client) userManager.getUser(b.getChallenged());
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.setPassword(user.getPassword());
        clientBuilder.setNick(user.getNick());
        clientBuilder.setName(user.getName());
        clientBuilder.setGold(user.getGold());
        clientBuilder.setBattleHistory(user.getBattleHistory());
        clientBuilder.setChallenge(b);
        clientBuilder.setCharacter(user.getCharacter());
        clientBuilder.setRegNumber(user.getRegNumber());
        try {
            Client finalClient = (Client) clientBuilder.build();
            storage.setValue("User:"+user.getNick(),finalClient);
        } catch (InstantiationException e) {
            throw new RuntimeException(e); // It is almost impossible to reach this statement
        }
    }
    public void banUser(String nick){
        Set<String> bannedList = (Set<String>) this.storage.getValue("Banned clients");
        if (bannedList == null){
            bannedList = new HashSet<>();
        }
        bannedList.add(nick);
    }
    public void unbanUser(String nick){
        Set<String> bannedList = (Set<String>) storage.getValue("Banned clients");
        bannedList.remove(nick);
    }
}
