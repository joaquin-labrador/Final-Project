package Restaurant;

public class Beverages {
    private double price;
    private String name;
    private int stock;
    //genereate a constructor empty
    public Beverages() {
    }
    public Beverages(double price, String name, int stock) {
        this.price = price;
        this.name = name;
        this.stock = stock;
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
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "Beverages{" + "price=" + price + ", name=" + name + ", stock=" + stock + '}';
    }


}

