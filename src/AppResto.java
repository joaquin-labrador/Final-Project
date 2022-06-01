import Employee.Employee;
import Files.EmployeeFile;
import Restaurant.Lounge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class AppResto {
    private String restoName;
    private List<Employee> restoEmployee = new ArrayList<>();
    private Lounge lounge = new Lounge();
    private final EmployeeFile employeeFile = new EmployeeFile();

    public AppResto() throws IOException {
        this.restoEmployee = employeeFile.getEmployeeList();

    }

    public AppResto(String restoName) throws IOException {
        this.restoName = restoName;
        this.restoEmployee = employeeFile.getEmployeeList();

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

}
