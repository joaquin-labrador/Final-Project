package Employee;

import Files.EmployeeFile;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Chef extends Employee implements EmployeeInterface {
    private double hourSalary;
    private boolean inEmergency = false;
    private double myProfit;


    //region CONSTRUCTORS GETTERS AND SETTERS
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
    public double getMyProfit(){
          return this.myProfit;
    }


    //endregion


    @Override
    public String toString() {
        return super.toString() + "Chef{" +
                "hourSalary=" + hourSalary +
                ", inEmergency=" + inEmergency + "\n" +
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
        System.out.println("3. Agregar stock");
        System.out.println("4. Salir");
    }

    @Override
    public void employeeOperations() throws IOException {
        try {
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
                    case 2 , 4:
                        double salaryDay = super.clockOut();
                        EmployeeFile employeeFile = new EmployeeFile();
                        employeeFile.saveMeChef(this, salaryDay);
                        exit(0);
                        break;
                    case 3:
                        System.out.println("En desarrollo");
                        break;
                }
            } while (op > 0 && op < 4);
        }catch (IOException e){
            System.out.println("Error al guardar");
        }finally {
            System.out.println("Gracias por usar nuestro sistema");
        }

    }
}
