package Restaurant;

import Employee.*;
import Files.EmployeeFile;
import Files.RestoFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kitchen {
    private List<Employee> kitchenEmployee = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();

    EmployeeFile employeeFile = new EmployeeFile();

    RestoFiles restoFiles = new RestoFiles();


    //region CONSTRUCTORS GETTERS AND SETTERS
    public Kitchen() throws IOException {

    }

    public Kitchen(List<Food> foodList) throws IOException {

        try {
            this.foodList = foodList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public List<Employee> getKitchenEmployee() {
        return kitchenEmployee;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }


    public void setKitchenEmployeeRead(List<Employee> kitchenEmployee) {
        for (Employee employee : kitchenEmployee) {
            if (employee instanceof Chef || employee instanceof Kitchener) {
                this.kitchenEmployee.add(employee);
            }
        }
    }

    public Food searchFood() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.foodList.toString());
        System.out.println("Ingrese el UUID del alimento que desea buscar: ");
        String UUID = scanner.nextLine();
        for (Food food : foodList) {
            if (food.getIdFood().toString().equals(UUID)) {
                return food;
            }
        }
        return null;
    }

    public void changeStock() throws IOException {
        Food food = searchFood();
        try {

            if (food != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese la cantidad de stock que desea cambiar: ");
                int stock = scanner.nextInt();
                food.setStock(stock);
                this.restoFiles.changeStockFileFood(food);

            } else {
                System.out.println("No se encontro el alimento");
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    //endregion
    @Override
    public String toString() {
        return "Kitchen{" + "KitchenEmployee=" + kitchenEmployee + ", foodList=" + foodList + '}';
    }
}
