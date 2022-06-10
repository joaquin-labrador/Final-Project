package Restaurant;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Ticket {
    private UUID idTickets;
    private String date;
    private double price;
    //region CONSTRUCTORS GETTERS AND SETTERS
    public Ticket() {
        this.idTickets = UUID.randomUUID();
        this.date = LocalDate.now().toString();
        this.price = 0;
    }
    public Ticket(double price) {
        this.date = LocalDate.now().toString();
        this.idTickets = UUID.randomUUID();
        this.price = price;
    }

    public UUID getIdTickets() {
        return idTickets;
    }
    public void setIdTickets(UUID idTickets) {
        this.idTickets = idTickets;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    //endregion
    @Override
    public String toString() {
        return "Ticket{" + "idTickets=" + idTickets + ", date=" + date + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(getIdTickets(), ticket.getIdTickets());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTickets());
    }


}
