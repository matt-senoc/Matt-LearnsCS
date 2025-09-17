public class Container {
    private String id;
    private String description;
    private double weight;

    public Container(String id, String description, double weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-12s | %.0fkg", id, description, weight);
    }
}