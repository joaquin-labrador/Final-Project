package Restaurant;

public class Beverages {
    private double price;
    private String name;
    private int stock;

    private int id;
    //region CONSTRUCTORS GETTERS AND SETTERS
    public Beverages() {
    }

    public Beverages(double price, String name, int stock, int id) {
        this.price = price;
        this.name = name;
        this.stock = stock;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    //endregion

    @Override
    public String toString() {
        return "Beverages{" + "price=" + price + ", name=" + name + ", stock=" + stock + '}';
    }

    public String toTicket(){
        return "Beverages{" + "price=" + price + ", name=" + name + "\n" +'}';
    }

}

