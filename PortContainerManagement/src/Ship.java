public class Ship {
    private String name;
    private String captain;

    public Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-12s", name, captain);
    }
}