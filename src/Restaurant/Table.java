package Restaurant;

public class Table {
    private int number;
    private int capacity;
    private boolean isAvailable = true;
    public Table(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }
}
