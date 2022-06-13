import Employee.*;
import Files.EmployeeFile;
import Files.RestoFiles;
import Files.TicketFile;
import Restaurant.*;

import java.io.IOException;
import java.util.*;

public final class AppResto {
    private String restoName;
    private List<Employee> restoEmployee = new ArrayList<>();
    private List<Beverages> beveragesList = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();
    private List<Menu> menuList = new ArrayList<>();
    private Map<Integer, Table> tableList = new HashMap<>();
    private final EmployeeFile employeeFile = new EmployeeFile();
    private final RestoFiles restoFiles = new RestoFiles();
    private Lounge lounge = new Lounge();

    private Kitchen kitchen;

    private TicketFile ticketFile = new TicketFile();

    private List<Ticket> ticketList = new ArrayList<>();

    public AppResto() throws IOException {
        this.restoEmployee = employeeFile.getEmployeeList();
        this.beveragesList = restoFiles.getBeveragesList();
        this.foodList = restoFiles.getFoodList();
        this.menuList = restoFiles.getMenuList();
        this.tableList = restoFiles.getTableList();
        this.ticketList = ticketFile.getTicketList();
        this.lounge = new Lounge( tableList, menuList, beveragesList, ticketList);
        this.lounge.setRestoEmployee(restoEmployee);
        this.kitchen = new Kitchen(foodList);
        this.kitchen.setKitchenEmployeeRead(restoEmployee);
    }

    public AppResto(String restoName) throws IOException {
        this.restoName = restoName;
        this.restoEmployee = employeeFile.getEmployeeList();
        this.beveragesList = restoFiles.getBeveragesList();
        this.foodList = restoFiles.getFoodList();
        this.menuList = restoFiles.getMenuList();
        this.tableList = restoFiles.getTableList();
        this.ticketList = ticketFile.getTicketList();
        this.lounge = new Lounge(tableList, menuList, beveragesList, ticketList);
        this.lounge.setRestoEmployee(restoEmployee);
        this.kitchen = new Kitchen(foodList);
        this.kitchen.setKitchenEmployeeRead(restoEmployee);


    }


    public List<Beverages> getBeveragesList() {
        return beveragesList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public Map<Integer, Table> getTableList() {
        return tableList;
    }

    public void setRestoName(String restoName) {
        this.restoName = restoName;
    }

    public void setRestoEmployee(List<Employee> restoEmployee) {
        this.restoEmployee = restoEmployee;
    }

    public List<Employee> getRestoEmployee() {
        return restoEmployee;
    }

    public String getRestoName() {
        return restoName;
    }

    public void showFile() {
        employeeFile.showFile();
    }

    public void showAvailableTables() {

    }

    public Employee signIn(String userName, String password) throws IOException {
        for (Employee employee : restoEmployee) {
            if (employee.getUserName().equals(userName) && employee.getPassword().equals(password)) {
                System.out.println("Bienvenido " + employee.getName() + " " + employee.getLastName());
                return employee;
            }
        }
        System.out.println("Usuario o contraseña incorrectos");
        return null;
    }

    public void userOptions(Employee user) throws IOException {
        try {

            if (user instanceof Kitchener userKitchener) {
                userKitchener.employeeOperations();
            } else if (user instanceof Host userHost) {
                userHost.setLounge(lounge);
                userHost.employeeOperations();
            } else if (user instanceof Server userServer) {
                userServer.setLounge(lounge);
                userServer.employeeOperations();
            }
            if (user instanceof Manager userManager) {
                userManager.setLounge(lounge);
                userManager.setMyEmployeeList(restoEmployee);
                userManager.setKitchen(kitchen);
                userManager.employeeOperations();
            }
            if (user instanceof Chef userChef) {
                userChef.setKitchen(kitchen);
                userChef.employeeOperations();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }


}
