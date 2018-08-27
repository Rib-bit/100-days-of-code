package masterclass;

import java.util.ArrayList;
import java.util.List;

public class Shield implements ISaveable {
    private String name;
    private String material;
    private String defense;
    private String integrity;


    public Shield() {
        this("shield", "pinewood", "2", "65");
    }

    public Shield(String name, String material, String defense, String integrity) {
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
        Shield object = new Shield(objects.get(0), objects.get(1), objects.get(2), objects.get(3));
        return object;
    }

    @Override
    public String toString() {
        return this.name + " - Defense score: " + this.defense +
                " for a shield made of " + this.material +
                "\nIntegrity is " + this.integrity + "%";
    }
}
