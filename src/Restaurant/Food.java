package Restaurant;

import java.time.LocalDate;
import java.util.UUID;

public class Food {
    private String food;
    private UUID idFood;
    private int stock;
    private LocalDate expirationDate;

    public Food() {
    }

    public Food(String food, UUID idFood, int stock, LocalDate expirationDate) {
        this.food = food;
        this.idFood = idFood;
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
