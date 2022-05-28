package Restaurant;

import Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Lounge {
    private List<Employee> employees = new ArrayList<>();
    private List<Table> tables = new ArrayList<>();
    private List<Menu> menu = new ArrayList<>();

    public Lounge() {
    }

    public Lounge(List<Employee> employees, List<Table> tables, List<Menu> menu) {
        this.employees = employees;
        this.tables = tables;
        this.menu = menu;
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
}
