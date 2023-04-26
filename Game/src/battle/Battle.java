package battle;

import minion.Minion;
import character.Character;
import user.Client;
import user.UserManager;

import java.util.Random;
import java.util.List;

public class Battle {
    private final Character character1;
    private final Character character2;
    private int roundNumber;
    private Client challenger;

    private Client challenged;
    public Battle(BattleRequest battleRequest){
        UserManager userManager = new UserManager();
        this.challenger = (Client) userManager.getUser(battleRequest.getChallenging());
        this.challenged = (Client) userManager.getUser(battleRequest.getChallenged());
        this.character1 = challenger.getCharacter().getCharacter();
        this.character2 = challenged.getCharacter().getCharacter();
    }
    public void fight(){
        int hp1 = calculateHp(character1);
        int hp2 = calculateHp(character2);
        while (hp1 != 0 && hp2 != 0){
            String roundWinner = playRound(character1, character2);
            switch (roundWinner) {
                case "both":
                    hp1--;
                    hp2--;
                    break;
                case "character1":
                    hp2--;
                    break;
                case "character2":
                    hp1--;
                    break;
            }
            roundNumber++;
        }

    }
    //poner un metodo para actualizar atributos de personajes (rabia, sangre, etc)

    private int calculateHp(Character character) {
        int hp = character.getHealth();
        List<Minion> minions = character.getMinions();
        for (Minion minion : minions) {
            hp += minion.getHealth();
        }
        return hp;
    }

    private int calculateAttackPotential(Character character) {
        return character.calculateAttackPotential();
    }

    private int calculateDefensePotential(Character character) {
        return character.calculateDefensePotential();
    }

    public String playRound(Character character1, Character character2){
        int potAt1 = calculateAttackPotential(character1);
        int potAt2 = calculateAttackPotential(character2);
        int potDf1 = calculateDefensePotential(character1);
        int potDf2 = calculateDefensePotential(character2);
        int attack1 = calculateSuccess(potAt1);
        int attack2 = calculateSuccess(potAt2);
        int defense1 = calculateSuccess(potDf1);
        int defense2= calculateSuccess(potDf2);
        if ((attack1 >= defense2) && (attack2 >= defense1)){
            return "both";
        } else if (attack1 >= defense2){
            return "character1";
        } else if (attack2 >= defense1){
            return "character2";
        } else {
            return "none";
        }
    }



    public int calculateSuccess(int potential){
        Random random = new Random();
        int hits = 0;
        for (int i = 0; i < potential; i++) {
            int number = random.nextInt(6) + 1;
            if (number >= 5){
                hits++;
            }
        }
        return hits;
    }

    public BattleResume giveBattleResume(){return null;}

}