package atributosPersonaje;

import java.io.Serializable;

public class atributoFuerza implements Serializable {

    private String name;

    private int efectividad;

    private boolean estaActivado = false;


    public atributoFuerza(String name, int efectividad){

        this.name = name;

        this.efectividad = efectividad;



    }

    public String getName(){

        return name;

    }

    public void setName (String name){

        this.name = name;


    }

    public int getEfectividad(){

        return efectividad;
    }

    public void setEfectividad(int efectividad){

        this.efectividad = efectividad;
    }

    public boolean isEstaActivado(){
        return estaActivado;
    }

    public void setEstaActivado(boolean estaActivado){
        this.estaActivado = estaActivado;
    }


}
