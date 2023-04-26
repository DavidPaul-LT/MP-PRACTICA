package atributosPersonaje;

import java.io.Serializable;

public class atributoSalud implements Serializable {

    protected  int health;


    public atributoSalud(){

    }

    public int getHealth (){
        return health;
    }

    public void  setHealth(int health){

        this.health = health;
    }

}
