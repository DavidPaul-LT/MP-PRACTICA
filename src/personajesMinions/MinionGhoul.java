package personajesMinions;

public class MinionGhoul extends Minion{

    private final int dependencia;

    public MinionGhoul(){

        super();

        type = "Ghoul";

        health = 2;

        precio = 10;

        dependencia = (int) (Math.random() * 6 +1);



    }



}
