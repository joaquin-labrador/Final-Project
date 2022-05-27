package PrincipalChef;

public class PrincipalChef extends Employee{

    private float salary;

    public PrincipalChef(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
