package masterclass;

public class Room {
    private int walls;
    private boolean ceiling;
    private String floor;
    private int doors;

    public Room(int walls, boolean ceiling, String floor, int doors) {
        this.walls = walls;
        this.ceiling = ceiling;
        this.floor = floor;
        this.doors = doors;
    }

    public void walkAround() {
        System.out.println("You walk around, thinking of new ways to procrastinate.");
    }

    public int getWalls() {
        return walls;
    }

    public boolean isCeiling() {
        return ceiling;
    }

    public String getFloor() {
        return floor;
    }

    public int getDoors() {
        return doors;
    }
}
