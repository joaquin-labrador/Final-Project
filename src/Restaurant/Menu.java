package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private double price;
    private String name;

    public Menu() {
    }

    public Menu(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
