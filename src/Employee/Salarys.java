package Employee;

public enum Salarys {
    CHEF(23.3), MANAGER(25), HOST(15.5), SERVER(17), KITCHENER(17.5);
    private final double salary;
    Salarys(double s){
        salary = s;
    }
   public double getSalary(){
        return salary;
    }
}
