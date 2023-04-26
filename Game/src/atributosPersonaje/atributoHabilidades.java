package atributosPersonaje;

public class atributoHabilidades {

    private String name;
    private int valorAtaque;
    private int valorDefensa;
    private int paraActivar;
    private boolean estaActivado;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValorAtaque() {
        return valorAtaque;
    }

    public void setValorAtaque(int valorAtaque) {
        this.valorAtaque = valorAtaque;
    }

    public int getValorDefensa() {
        return valorDefensa;
    }

    public void setValorDefensa(int valorDefensa) {
        this.valorDefensa = valorDefensa;
    }

    public int getParaActivar() {
        return paraActivar;
    }

    public void setParaActivar(int paraActivar) {
        this.paraActivar = paraActivar;
    }


    public void activate() {
        this.estaActivado = true;
    }

    public boolean isEstaActivado() {
        return estaActivado;
    }

    public void setIsActivated(boolean isActivated) {
        this.estaActivado = isActivated;
    }


}
