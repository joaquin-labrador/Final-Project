package Restaurant;

import com.google.gson.internal.bind.util.ISO8601Utils;

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

    private List<Beverages> beveragesOfTable = new ArrayList<>();

    private double totalPriceBeverages  = 0;


    //region CONSTRUCTORS GETTERS AND SETTERS
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

    public double getTotalPrice() {
        return totalPrice + totalPriceBeverages;
    }

    public List<Beverages> getBeveragesOfTable() {
        return beveragesOfTable;
    }

    public void setBeveragesOfTable(List<Beverages> beveragesOfTable) {
        this.beveragesOfTable = beveragesOfTable;
    }

    public void setTotalPrice(List<Menu> totalPrice) {
        this.totalPrice = totalPrice.stream().mapToDouble(Menu::getPrice).sum();
    }

    public void setTotalPriceBeverages(List<Beverages> totalPriceBeverages) {
        this.totalPriceBeverages = totalPriceBeverages.stream().mapToDouble(Beverages::getPrice).sum();
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

    //endregion
    @Override
    public String toString() {
        return "Table{" + "number=" + number + ", capacity=" + capacity + ", isAvailable=" + isAvailable +'}';
    }

    public String foodOfTableToString() {
        StringBuilder sb = new StringBuilder();
        for (Menu menu : foodOfTable) {
            sb.append(menu.toString()).append("\n");
        }
        return sb.toString();
    }
    public String beveragesOfTableToString() {
        StringBuilder sb = new StringBuilder();
        for (Beverages beverages : beveragesOfTable) {
            sb.append(beverages.toTicket()).append("\n");
        }
        return sb.toString();
    }

    public String showTicket() {
        return "Mesa: " + this.getNumber() +
                "\n" +
                "Tickets: \n" + foodOfTableToString() +
                "Bebidas:  \n  " + beveragesOfTableToString() +
                "\n Total food: " + this.totalPrice + "$" +
                "\n Total beverages "+ this.totalPriceBeverages + "$" +"\n";
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
