import Employee.*;
import Files.EmployeeFile;
import Files.RestoFiles;
import Restaurant.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class AppResto {
    private String restoName;
    private List<Employee> restoEmployee = new ArrayList<>();
    private List<Beverages> beveragesList = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();
    private List<Menu> menuList = new ArrayList<>();
    private List<Table> tableList = new ArrayList<>();
    private final EmployeeFile employeeFile = new EmployeeFile();
    private final RestoFiles restoFiles = new RestoFiles();
    private final Lounge lounge = new Lounge();

    public AppResto() throws IOException {
        this.restoEmployee = employeeFile.getEmployeeList();
        this.beveragesList = restoFiles.getBeveragesList();
        this.foodList = restoFiles.getFoodList();
        this.menuList = restoFiles.getMenuList();
        this.tableList = restoFiles.getTableList();
    }

    public AppResto(String restoName) throws IOException {
        this.restoName = restoName;
        this.restoEmployee = employeeFile.getEmployeeList();
        this.beveragesList = restoFiles.getBeveragesList();
        this.foodList = restoFiles.getFoodList();
        this.menuList = restoFiles.getMenuList();
        this.tableList = restoFiles.getTableList();


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

    public List<Table> getTableList() {
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

    public void showFile(){
        employeeFile.showFile();
    }

    public void showAvailableTables(){

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

    public void userOptions(Employee user){
        if(user instanceof Kitchener){
            Kitchener userKitchener = (Kitchener) user;
            userKitchener.menuKitchener();
        }
        if(user instanceof Host){
            Host userHost = (Host) user;
            userHost.menuHost();
        }
        if(user instanceof Server){
            Server userServer = (Server) user;
            userServer.menuServer();
        }
        if(user instanceof Manager){
            Manager userManager = (Manager) user;
            userManager.menuManager();
        }
        if(user instanceof Chef){
            Chef userChef = (Chef) user;
            userChef.menuChef();
        }
    }



}
