package Employee;

import Restaurant.*;

import java.util.List;

public interface EmployeeTask {
    void takeOrder(Table table);
    void bookTable(Table table, int numberTable);
    void deleteEmployee(Employee employee, Integer id);
    void priceEdit(Menu manu, double newPrice);
    void agreeStock(Food food);
    void agreePlate(Menu menu, Lounge lounge);
    void cancelBook(Table table, int numberTable);
    void addTakeAway(TakeAway takeAway , List<Food> takeAwayFood);
}
