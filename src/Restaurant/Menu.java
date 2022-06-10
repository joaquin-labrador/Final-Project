package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private double price;
    private String name;

    private int id;

    //region CONSTRUCTORS GETTERS AND SETTERS
    public Menu() {

    }

    public Menu(double price, String name, int id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //endregion
    @Override
    public String toString() {
        return "Menu{" + "price=" + price + ", name=" + name +  '}';
    }
}
