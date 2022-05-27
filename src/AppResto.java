import Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public final class AppResto {
    private String restoName;
    private List<Employee> restoEmployee = new ArrayList<>();

    public AppResto() {
    }

    public AppResto(String restoName,List<Employee> restoEmployee) {
        this.restoName = restoName;
        this.restoEmployee = restoEmployee;

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
}
