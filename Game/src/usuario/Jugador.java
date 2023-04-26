package usuario;

import personajesPrincipales.CreadorPersonajes;
import personajesPrincipales.PersonajesFactory;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class Jugador extends Usuario{

    private CreadorPersonajes personaje;

    private Boolean estaBaneado = false;

    private int oro = 200;

    private Date lastLost;

    private boolean recibirNotificaciones = false;

    private String pendienteRecibirNotificacion;

    private boolean combateEnMarcha = false;

    private String id;

    public Jugador( String nombreUsuario, String contrasena, String apodo){

        super(nombreUsuario, contrasena, apodo);

    }

    public void setPersonaje() throws FileNotFoundException {
        System.out.println("Que personajes quieres");
        System.out.println("Que personajes quieres");
        System.out.println("Que personajes quieres");
        System.out.println("Que personajes quieres");
        Scanner sc = new Scanner(System.in);
        String nombrePersonaje = sc.nextLine();
        PersonajesFactory personajesFactory = new PersonajesFactory();
        personaje = personajesFactory.crearPersonajes(nombrePersonaje);
    }


}
