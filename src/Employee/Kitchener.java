package Employee;

import java.time.LocalDate;

public class Kitchener extends Employee{
    private double hourSalary;

    public Kitchener() {
    }

    public Kitchener(String name, String lastName, String dateOfBrith, Integer id, String userName, String password, double hourSalary) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;
    }

    public double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }


    @Override
    public String toString() {
        return super.toString() + "Kitchener{" +
                "hourSalary=" + hourSalary  +
                '}';
    }

    @Override
    protected void finishDay() {

    }
}
