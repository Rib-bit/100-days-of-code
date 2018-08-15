package masterclass;

public class Plant {
    private String type;
    private String name;
    private boolean watered;

    public void waterPlant() {
        if (!watered) {
            System.out.println("You water the " + type + ". You're welcome, " + name + "!");
            watered = true;
        } else {
            System.out.println("You wouldn't want to drown " + name + " now, would you?");
        }
    }

    public Plant() {
        this("unknown", "Planty McPlantface", false);
    }

    public Plant(String type, String name, boolean watered) {
        this.type = type;
        this.name = name;
        this.watered = watered;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean isWatered() {
        return watered;
    }
}
