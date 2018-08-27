package masterclass;

import java.util.ArrayList;
import java.util.List;

public class Armour implements ISaveable {
    private String name;
    private String material;
    private String defense;
    private String integrity;

    public Armour() {
        this("mail", "copper", "5", "40");
    }

    public Armour(String name, String material, String defense, String integrity) {
        this.name = name;
        this.material = material;
        this.defense = defense;
        this.integrity = integrity;
    }

    @Override
    public List<String> saveToArrayList(String name, String material, String defense, String integrity) {
        List<String> state = new ArrayList<String>();

        state.add(name);
        state.add(material);
        state.add(defense);
        state.add(integrity);

        return state;
    }

    @Override
    public ISaveable populateFields(List<String> objects) {
        Armour object = new Armour(objects.get(0), objects.get(1), objects.get(2), objects.get(3));
        return object;
    }

    @Override
    public String toString() {
        return this.name + " - Defense score: " + this.defense +
                " for armour made of " + this.material +
                "\nIntegrity is " + this.integrity + "%";
    }
}
