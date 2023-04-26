package atributosPersonaje;

public class atributoArma extends Equipamiento{

    private int manosOcupadas;

    public atributoArma (String name, int modoAtaque, int modoDefensa, int manosOcupadas){

        super(name, modoAtaque, manosOcupadas);
        this.manosOcupadas = manosOcupadas;

    }

    public int getManosOcupadas(){
        return manosOcupadas;
    }

    public void setManosOcupadas(int manosOcupadas){
        this.manosOcupadas = manosOcupadas;
    }


    @Override
    public void modifcarAtributos() {

    }
}

