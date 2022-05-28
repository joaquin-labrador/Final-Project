package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private double price;
    private List<Food>  ingredients = new ArrayList<>();

    public Menu() {
    }

    public Menu(double price, List<Food> ingredients) {
        this.price = price;
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Food> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Food> ingredients) {
        this.ingredients = ingredients;
    }
}
