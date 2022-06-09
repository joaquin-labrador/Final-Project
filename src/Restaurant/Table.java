package Restaurant;

import java.util.Objects;

public class Table {
    private int number;
    private int capacity;
    private boolean isAvailable = true;

    public Table() {
    }

    public Table(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setOccupied() {
        this.isAvailable = false;
    }

    public void setAvailable( ) {
        isAvailable = true;
    }
    @Override
    public String toString() {
        return "Table{" + "number=" + number + ", capacity=" + capacity + ", isAvailable=" + isAvailable + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table table)) return false;
        return getNumber() == table.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
