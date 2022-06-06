package Employee;

import Restaurant.Lounge;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;

public class Manager extends Employee implements Menus, EmployeeTask {
    private Double hourSalary;
    private Boolean inEmergency = false;

    private Lounge lounge;


    public Manager() {

    }

    public Manager(String name, String lastName, String dateOfBrith, Integer id, String userName, String password, Double hourSalary) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;

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

    public void setInEmergency() {
        this.inEmergency = true;
    }

    public void setLounge(Lounge lounge) {
        this.lounge = lounge;
    }

    public Lounge getLounge() {
        return lounge;
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" +
                "hourSalary=" + hourSalary +
                ", inEmergency=" + inEmergency + "\n" +
                '}';
    }

    @Override
    public void showMenu() {
        System.out.println("1. Fichar entrada");
        System.out.println("2. Fichar salida");
        System.out.println("3. Reservar mesa");
        System.out.println("4. Agregar empleados");
        System.out.println("5. Editar precios");
        System.out.println("6. Agregar platos");
        System.out.println("7. Ver cuanta mesa");
        System.out.println("8. Cancelar reserva");
        System.out.println("9. Ver mesas");
        System.out.println("10. Salir");

    }



    @Override
    public void employeeOperations() {
        int op;
        Scanner sc = new Scanner(System.in);
        do {
            showMenu();
            op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    super.clockIn();
                    System.out.println(toString());
                }
                case 2 -> {
                    super.clockOut();
                    System.out.println(toString());
                }
                case 3 -> lounge.reserveTable();
                case 4 -> System.out.println("En desarrollo");
                case 5 -> System.out.println("En desarrollo");
                case 6 -> System.out.println("En desarrollo");
                case 7 -> System.out.println("En desarrollo");
                case 8 -> System.out.println("En desarrollo");
                case 9 -> System.out.println(lounge.getTables().toString());
                case 10 -> exit(0);
            }
        } while (op > 0 && op < 11);
    }
}