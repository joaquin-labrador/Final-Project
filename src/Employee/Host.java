package Employee;

import Employee.Employee;

import java.time.LocalDate;

public class Host extends Employee {


    private double hourSalary;

    private double tips;

    public Host() {
    }

    public Host(String name, String lastName, String dateOfBrith, Integer id, String userName, String password, double hourSalary) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;
    }


    public double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }

    public double getTips() {
        return tips;
    }

    public void setTips(double tips) {
        this.tips = tips;
    }


    @Override
    public String toString() {
        return super.toString() + "Host{" +
                "hourSalary=" + hourSalary +
                ", tips=" + tips + "\n" +
                '}';
    }
    public void menuHost(){
        System.out.println("Menu Host in progress");

    }
}
