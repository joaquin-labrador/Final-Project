package Employee;

import Employee.Employee;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;

public class Host extends Employee implements Menus, EmployeeTask {


    private double hourSalary;

    private double tips;

    public Host() {
    }

    public Host(String name, String lastName, String dateOfBrith, Integer id, String userName, String password, double hourSalary) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;
        this.tips = 0;
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


    @Override
    public void showMenu() {

        System.out.println("Selecciona una opcion: ");
        System.out.println("1. Fichar entrada");
        System.out.println("2. Fichar salida");
        System.out.println("3. Reservar mesa");
        System.out.println("4. Salir");

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
                    System.out.println("En desarrollo");
                case 4:
                    exit(0);
                    break;


            }
        } while (op > 0 && op < 4);
    }
}
