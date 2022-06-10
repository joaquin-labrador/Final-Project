package Employee;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;

public class Kitchener extends Employee
        implements Menus, EmployeeTask {
    private double hourSalary;

    //region CONSTRUCTORS GETTERS AND SETTERS
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

    //endregion
    @Override
    public String toString() {
        return super.toString() + "Kitchener{" +
                "hourSalary=" + hourSalary + "\n" +
                '}';
    }


    @Override
    public void showMenu() {
        System.out.println("Selecciona una opcion: ");
        System.out.println("1. Fichar entrada");
        System.out.println("2. Fichar salida");
        System.out.println("3. Salir");

    }


    @Override
    public void employeeOperations() {
        int op;
        Scanner sc = new Scanner(System.in);
        do {
            showMenu();
            op = sc.nextInt();
            switch (op) {
                case 1:
                    super.clockIn();
                    System.out.println(toString());
                    break;
                case 2:
                    super.clockOut();
                    System.out.println(toString());
                    break;
                case 3:
                    exit(0);
                    break;


            }
        } while (op == 1 || op == 2); //While para que el usuario seleccione una opcion valida
    }
}