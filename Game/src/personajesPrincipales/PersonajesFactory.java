package personajesPrincipales;

import java.io.FileNotFoundException;

public class PersonajesFactory implements CreadorPersonajes {

    public PersonajesFactory(){}

    @Override
    public CreadorPersonajes crearPersonajes(String name) throws FileNotFoundException {
        switch (name){
            case "Werewolf":{
                WereWolfCreador wereWolfCreador = new WereWolfCreador();
                return wereWolfCreador.setWereWolf();

            }
            case "Vampire":{
                VampireCreador vampireCreador = new VampireCreador();
                return vampireCreador.setVampire();

            }
            case "Hunter":{
                HunterCreador hunterCreador = new HunterCreador();
                return hunterCreador.setHunter();

            }

        }
        return null;
    }
}
