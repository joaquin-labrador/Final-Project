package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class TakeAway {
    private String address;
    private boolean isDelivered = false;

    public TakeAway() {
    }

    private List<Menu> takeAwayFood= new ArrayList<>();


    public TakeAway(String address, List<Menu> takeAwayFood) {
        this.address = address;
        this.takeAwayFood = takeAwayFood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public List<Menu> getTakeAwayFood() {
        return takeAwayFood;
    }

    public void setTakeAwayFood(List<Menu> takeAwayFood) {
        this.takeAwayFood = takeAwayFood;
    }

    @Override
    public String toString() {
        return "TakeAway{" +
                "address='" + address + '\'' +
                ", isDelivered=" + isDelivered +
                ", takeAwayFood=" + takeAwayFood +
                '}';
    }
}
