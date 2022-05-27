package Chef;


public class Chef extends Employee{


    private Float salary;

    public Chef() {
    }

    public Chef(Float salary) {
        this.salary = salary;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}
