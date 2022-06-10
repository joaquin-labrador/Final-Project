package Restaurant;

import Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
    private List<Employee> KitchenEmployee = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();

    //region CONSTRUCTORS GETTERS AND SETTERS
    public Kitchen() {
    }

    public Kitchen(List<Employee> kitchenEmployee, List<Food> foodList) {
        KitchenEmployee = kitchenEmployee;
        this.foodList = foodList;
    }

    public List<Employee> getKitchenEmployee() {
        return KitchenEmployee;
    }

    public void setKitchenEmployee(List<Employee> kitchenEmployee) {
        KitchenEmployee = kitchenEmployee;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    //endregion
    @Override
    public String toString() {
        return "Kitchen{" + "KitchenEmployee=" + KitchenEmployee + ", foodList=" + foodList + '}';
    }
}
