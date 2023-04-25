package atributosPersonaje;

import java.io.Serializable;

public abstract class Equipamiento implements Serializable {

    private String name;

    private  int modoAtaque;

    private  int modoDefensa;

    private  boolean estaActivado = false;

    public Equipamiento(String name, int modoAtaque, int modoDefensa){

        this.name = name;

        this.modoAtaque = modoAtaque;

        this.modoDefensa = modoDefensa;

    }

    public String getName(){
        return name;

    }

    public void setName(String name){
         this.name = name;

    }


    public int getModoAtaque(){

        return modoAtaque;

    }


    public void setModoAtaque( int modoAtaque){

        this.modoAtaque = modoAtaque;

    }

    public int getModoDefensa(){

        return modoDefensa;
    }

    public void setModoDefensa(int modoDefensa){

        this.modoDefensa = modoDefensa;

    }

    public boolean isEstaActivado(){
        return estaActivado;
    }

    public void setEstaActivado (boolean estaActivado){
        this.estaActivado = estaActivado;

    }

    public abstract void modifcarAtributos();

}
