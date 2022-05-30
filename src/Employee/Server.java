package Employee;

import Employee.Employee;

import java.time.LocalDate;

public class Server extends Employee {

    private double hourSalary;

    private double tips;

    public Server() {

    }

    public Server(String name, String lastName, LocalDate dateOfBrith, Integer id, String userName, String password, double hourSalary, double tips) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;
        this.tips = tips;
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
    protected void finishDay() {

    }

    @Override
    public String toString() {
        return super.toString() + "Server{" +
                "hourSalary=" + hourSalary +
                ", tips=" + tips +
                '}';
    }
}
