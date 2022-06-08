package Restaurant;

import Employee.*;

import java.io.IOException;
import java.util.*;

public class Lounge implements LoungueTask {
    private List<Employee> employees = new ArrayList<>();
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Menu> menu = new ArrayList<>();
    private List<Beverages> beverages = new ArrayList<>();

    public Lounge() {
    }

    public Lounge(List<Employee> employees, Map<Integer, Table> tables, List<Menu> menu, List<Beverages> beverages) {
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

    public Map<Integer, Table> getTables() {
        return tables;
    }

    public void setTables(Map<Integer, Table> tables) {
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

    @Override
    public void reserveTable() {
        boolean isBooking = false;
        Scanner sc = new Scanner(System.in);
        int table = 0;
        int people = 0;
        int op = 0;
        do {
            try {
                System.out.println("Ingrese el numero de la mesa a reservar : ");
                table = sc.nextInt();
                System.out.println("Ingrese la cantidad de comensales : ");
                people = sc.nextInt();
                isBooking = bookTable(table, people);
            } catch (InputMismatchException e) {
                System.out.println("Error ingresaste un caracter no valido");
                isBooking = true;
            } finally {
                if (isBooking) {
                    try {
                        System.out.println("Desea no reservar otra mesa? (Ingrese 1 para otra reservar otra mesa)");
                        op = sc.nextInt();
                        if (op == 1) {
                            isBooking = false;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error ingresaste un caracter no valido");
                    }
                }
            }


        } while (!isBooking);
    }

    @Override
    public boolean bookTable(int tableNumber, int capacity) {
        if (tableNumber > 0 && tableNumber <= tables.size()) {
            for (Map.Entry<Integer, Table> table : tables.entrySet()) {
                if (table.getValue().getNumber() == tableNumber) {
                    if (table.getValue().getCapacity() >= capacity) {
                        table.getValue().setCapacity(capacity);
                        table.getValue().setOccupied();
                        return true;
                    } else {
                        System.out.println("No hay suficiente capacidad para la cantidad de comensales");
                        return false;
                    }
                }
            }
        } else
            System.out.println("Table not found");
        return false;
    }


}