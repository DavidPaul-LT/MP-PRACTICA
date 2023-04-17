package battle;

import java.util.Random;

public class Battle {
    private int roundNumber;

    public void fight(character1, character2){
        int hp1 = calculateHp(character1);
        int hp2 = calculateHp(character2);
        while (hp1 != 0 and hp2 != 0){
            roundWinner = playRound(character1, character2);
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
            roundNumber++
        }

    }

    public string playRound(character1, character2){
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

    public int calculateSuccess(potential){
        Random random = new Random();
        int hits = 0;
        for (int i = 0; i < potential; i++) {
            int number = random.nextInt(6) + 1;
            if (number >= 5){
                hits++;
            }
        }
    }

    public BattleResume giveBattleResume(){return null;}

}
