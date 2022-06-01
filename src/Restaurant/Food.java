package Restaurant;

import java.time.LocalDate;
import java.util.UUID;

public class Food {
    private String food;
    private UUID idFood;
    private int stock;
    private String expirationDate;

    public Food() {
    }

    public Food(String food,  int stock, String expirationDate) {
        this.food = food;
        this.idFood = UUID.randomUUID();
        this.stock = stock;
        this.expirationDate = expirationDate;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public UUID getIdFood() {
        return idFood;
    }

    public void setIdFood(UUID idFood) {
        this.idFood = idFood;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
