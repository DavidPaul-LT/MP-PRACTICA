package personajesMinions;



public class MinionHuman extends Minion {

    private final  int lealtad;


    public MinionHuman(){

        super();
        type = "Human";
        health = 1;
        precio = 2;
        lealtad = (int) (Math.random() * 4 + 1);

    }


}
