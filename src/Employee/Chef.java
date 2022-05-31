package Employee;

import java.time.LocalDate;

public class Chef extends Employee{
    private double hourSalary;
    private boolean inEmergency = false;


    public Chef() {
    }

    public Chef(String name, String lastName, String dateOfBrith, Integer id, String userName, String password, double hourSalary) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;
    }


    public double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }

    public boolean isInEmergency() {
        return inEmergency;
    }

    public void setInEmergency() {
        this.inEmergency = true;
    }

    @Override
    public String toString() {
        return super.toString() + "Chef{" +
                "hourSalary=" + hourSalary +
                ", inEmergency=" + inEmergency +
                '}';
    }

}
