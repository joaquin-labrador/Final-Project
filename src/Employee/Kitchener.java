package Employee;

import Files.EmployeeFile;

import java.io.IOException;
import java.util.Scanner;

import static Files.WriteNewEmployees.changePassword;
import static java.lang.System.exit;

public class Kitchener extends Employee
        implements EmployeeInterface {
    private double hourSalary;
    private double myProfit;

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

    public double getMyProfit() {
        return myProfit;
    }

    //endregion
    @Override
    public String toString() {
        return super.toString() + "Kitchener{" +
                "hourSalary=" + hourSalary + "\n" +
                '}';
    }


    @Override
    public void calculateProfit(double hours) {
        this.myProfit += (hours * this.hourSalary);

    }

    @Override
    public void showMenu() {
        System.out.println("Selecciona una opcion: ");
        System.out.println("1. Fichar entrada");
        System.out.println("2. Fichar salida");
        System.out.println("3. Cambiar contraseña");
        System.out.println("4. Salir");

    }


    @Override
    public void employeeOperations() throws IOException {
        try {
            int op;
            Scanner sc = new Scanner(System.in);
            boolean exit = false;
            do {
                showMenu();
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        super.clockIn();
                        break;
                    case 2, 4:
                        double salaryDay = super.clockOut();
                        EmployeeFile employeeFile = new EmployeeFile();
                        employeeFile.saveMeKitchener(this, salaryDay);
                        exit = true;
                        exit(0);
                        break;
                    case 3:
                        changePassword(this);


                }
            } while (!exit); //While para que el usuario seleccione una opcion valida
        } catch (IOException e) {
            System.out.println("Error al guardar el empleado");
        } finally {
            System.out.println("Gracias por usar nuestro sistema");
            exit(0);
        }

    }
}