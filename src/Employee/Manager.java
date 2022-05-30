package Employee;

public class Manager extends Employee{
    private Double hourSalary;



    @Override
    protected void finishDay() {
        super.setWorking(false);
        // Calculas la deferencia de el clock in con el clockout
    }
}
