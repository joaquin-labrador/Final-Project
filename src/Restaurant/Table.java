package Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Table {
    private int number;
    private int capacity;
    private boolean isAvailable = true;

    private double totalPrice;

    private List<Menu> foodOfTable = new ArrayList<>();

    public Table() {
        this.foodOfTable = null;
        this.totalPrice = 0;
    }

    public Table(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
        this.foodOfTable = null;
        this.totalPrice = 0;
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

    public void setAvailable() {
        this.totalPrice = 0;
        this.foodOfTable.clear();
        isAvailable = true;
    }


    public List<Menu> getFoodOfTable() {
        return foodOfTable;
    }


    public void setFoodOfTable(List<Menu> foodOfTable) {
        this.foodOfTable = foodOfTable;
    }

    @Override
    public String toString() {
        return "Table{" + "number=" + number + ", capacity=" + capacity + ", isAvailable=" + isAvailable +
                (this.foodOfTable != null ? ", foodOfTable=" + foodOfTableToString() : "") +
                ", totalPrice= " + totalPrice + "\n" + '}';
    }

    public String foodOfTableToString() {
        StringBuilder sb = new StringBuilder();
        for (Menu menu : foodOfTable) {
            sb.append(menu.toString()).append("\n");
        }
        return sb.toString();
    }

    public void tableOperations(){
        Scanner sc = new Scanner(System.in);
        int op = 0;

    }

    public String showTicket() {
        return "Mesa: " + this.getNumber() +
                "\n" +
                "Tickets: \n" + foodOfTableToString() + "\n Total: " + this.totalPrice;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table table)) return false;
        return getNumber() == table.getNumber();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(List<Menu> totalPrice) {
        this.totalPrice = totalPrice.stream().mapToDouble(Menu::getPrice).sum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
