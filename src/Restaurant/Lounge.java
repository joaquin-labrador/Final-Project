package Restaurant;

import Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Lounge {
    private String name;
    private List<Employee> employees = new ArrayList<>();
    private List<Table> tables = new ArrayList<>();
    private List<Menu> menu = new ArrayList<>();
    private double profit;
}
