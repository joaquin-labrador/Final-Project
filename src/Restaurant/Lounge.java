package Restaurant;

import Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Lounge {
    private List<Employee> employees = new ArrayList<>();
    private List<Table> tables = new ArrayList<>();
    private List<Menu> menu = new ArrayList<>();
    private List<Beverages> beverages = new ArrayList<>();

    public Lounge() {
    }

    public Lounge(List<Employee> employees, List<Table> tables, List<Menu> menu, List<Beverages> beverages) {
        this.employees = employees;
        this.tables = tables;
        this.menu = menu;
        this.beverages = beverages;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Menu> getMenu() {
        return menu;
    }



    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<Beverages> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<Beverages> beverages) {
        this.beverages = beverages;
    }

    @Override
    public String toString() {
        return "Lounge{" +
                "employees=" + employees +
                ", tables=" + tables +
                ", menu=" + menu +
                ", beverages=" + beverages +
                '}';
    }
}
