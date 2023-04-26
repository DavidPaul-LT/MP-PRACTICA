package personajesMinions;

import atributosPersonaje.atributoSalud;

public class Minion extends atributoSalud {

    protected int precio;
    protected String type;


    public Minion () {
        super();
    }

    public int computeHealth(){
        return health;
    }

    public String getType(){
        return type;
    }

    public int getPrecio(){
        return precio;
    }



}
