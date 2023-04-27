package screen;

import interfaces.Screen;
import storage.Storage;
import user.Client;
import user.ClientBuilder;
import user.User;

import java.util.Scanner;

public class ClientMenuScreen implements Screen {
    public static String TITLE = "Menú de jugador";
    private Client user;
    public ClientMenuScreen(User user) {
        this.user = (Client) user;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                //TODO Add RoleCustomizationScreen
                break;
            case 2:
                new BattleRequestScreen(this.user);
                break;
            case 3:
                new CambatHistoryScreen(this.user);
                break;
            case 4:
                new RankingScreen(this.user);
                break;
            case 5:
                new DeleteAccountScreen(this.user);
                break;
            case 6:
                new MainScreen();
                break;
            default:
                this.loadOptions();
        }
    }
    private void loadChallengeOptions(){
        System.out.println("¡Tienes un desafío pendiente!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Aceptas el desafío? [S/N]");
        switch (scanner.nextLine()){
            case "S":
                new PreBattleScreen(this.user.getChallenge());
                break;
            case "N":
                ClientBuilder clientBuilder = new ClientBuilder();
                clientBuilder.setChallenge(null);
                clientBuilder.setRegNumber(this.user.getRegNumber());
                clientBuilder.setName(this.user.getName());
                clientBuilder.setNick(this.user.getNick());
                clientBuilder.setGold(this.user.getGold());
                clientBuilder.setPassword(this.user.getPassword());
                clientBuilder.setCharacter(this.user.getCharacter());
                clientBuilder.setBattleHistory(this.user.getBattleHistory());
                try {
                    Client newClient = (Client) clientBuilder.build();
                    Storage.getInstance().setValue("User:"+this.user.getNick(),newClient);
                    new ClientMenuScreen(newClient);
                } catch (InstantiationException e) {
                    System.out.print("Ocurrió un error al actualizar el estado del desafío pendiente");
                }
                break;
            default:
                this.loadOptions();
        }
    }
    @Override
    public void loadOptions() {
        Screen.addSpacing();
        if (user.getChallenge() != null){
            this.loadChallengeOptions();
        }
        Screen.addSpacing();
        System.out.println(TITLE);
        System.out.println("Personalizar rol [1]");
        System.out.println("Desafiar [2]");
        System.out.println("Mis combates [3]");
        System.out.println("Ver ranking [4]");
        System.out.println("Borrar cuenta [5]");
        System.out.println("Cerrar sesión [6]");
        System.out.print("Seleccion: ");
        this.getOption();
    }
}
