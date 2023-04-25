package equipment;

import interfaces.Factory;

import java.io.Serializable;

public class EquipmentFactory implements Factory {
    private WeaponFactory wpf;

    private ArmorFactory af;

    public EquipmentFactory (){
        af = new ArmorFactory();
        wpf = new WeaponFactory();
    }

    public Equipment create() {
        return null;
    }
}
