package atributosPersonaje;

public class atributoDebilidad {

    private String name;
    private int sensibilidad;
    private boolean estaActivado = false;

    public atributoDebilidad(String name, int sensivility) {
        this.name = name;
        this.sensibilidad = sensivility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(int sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public boolean isActive() {
        return estaActivado;
    }

    public void setIsActivated(boolean isActivated) {
        this.estaActivado = isActivated;
    }

}
