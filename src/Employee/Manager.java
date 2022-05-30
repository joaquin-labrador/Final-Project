package Employee;

import java.time.LocalDate;

public class Manager extends Employee{
    private Double hourSalary;
    private Boolean inEmergency = false;


    public Manager() {

    }

    public Manager(String name, String lastName, LocalDate dateOfBrith, Integer id, String userName, String password, Double hourSalary, Boolean inEmergency) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;
        this.inEmergency = inEmergency;
    }

    public Double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(Double hourSalary) {
        this.hourSalary = hourSalary;
    }

    public Boolean getInEmergency() {
        return inEmergency;
    }

    public void setInEmergency(Boolean inEmergency) {
        this.inEmergency = inEmergency;
    }

    @Override
    protected void finishDay() {
        super.setWorking(false);
        // Calculas la deferencia de el clock in con el clockout
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" +
                "hourSalary=" + hourSalary +
                ", inEmergency=" + inEmergency +
                '}';
    }
}
