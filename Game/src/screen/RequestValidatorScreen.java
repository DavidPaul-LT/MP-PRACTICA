package screen;

import battle.BattleRequest;
import interfaces.Screen;
import storage.Storage;
import user.Operator;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class RequestValidatorScreen implements Screen {
    public static final String TITLE = "Validar desafíos pendientes";
    private Operator user;
    public RequestValidatorScreen(Operator user) {
        this.user = user;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        Storage auxStorage = Storage.getInstance();
        ArrayDeque<BattleRequest> requestDeque = (ArrayDeque<BattleRequest>) auxStorage.getValue("Battle requests");
        Scanner scanner = new Scanner(System.in);
        if (requestDeque == null){
            System.out.println("No hay desafíos pendientes");
            scanner.nextLine();
            new OperatorMenuScreen(this.user);
        }else {
            BattleRequest firstRequest = requestDeque.removeFirst();
            System.out.println("Challenging player: " + firstRequest.getChallenging());
            System.out.println("Challenged player: " + firstRequest.getChallenged());
            System.out.println("Gold bet: " + firstRequest.getGoldBet());
            System.out.print("Validar desafío [S/N]: ");
            switch (scanner.nextLine()) {
                case "S":
                    user.validateBattleRequest(firstRequest);
                    auxStorage.setValue("Battle requests", requestDeque);
                    new OperatorMenuScreen(this.user);
                    break;
                case "N":
                    auxStorage.setValue("Battle requests", requestDeque);
                    new OperatorMenuScreen(this.user);
                    break;
                default:
                    this.loadOptions();
            }
        }
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        this.getOption();
    }
}
