package masterclass;

import java.util.ArrayList;
import java.util.List;

public class Weapon implements ISaveable {
    private String name;
    private String damageType;
    private String damage;
    private String integrity;


    public Weapon() {
        this("sword", "blunt", "2", "50");
    }

    public Weapon(String name, String damageType, String damage, String integrity) {
        this.name = name;
        this.damageType = damageType;
        this.damage = damage;
        this.integrity = integrity;
    }

    @Override
    public List<String> saveToArrayList(String name, String damageType,String damage, String integrity) {
        List<String> state = new ArrayList<String>();

        state.add(name);
        state.add(damageType);
        state.add(damage);
        state.add(integrity);

        return state;
    }

    @Override
    public ISaveable populateFields(List<String> objects) {

        Weapon object = new Weapon(objects.get(0), objects.get(1), objects.get(2), objects.get(3));
        return object;
    }

    @Override
    public String toString() {
        return this.name + " - Attack score: " + this.damage +
                ", " + this.damageType + " damage" +
                "\nIntegrity is " + this.integrity + "%";
    }
}
