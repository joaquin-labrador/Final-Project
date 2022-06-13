package Employee;

import Files.EmployeeFile;
import Restaurant.Kitchen;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Chef extends Employee implements EmployeeInterface {
    private double hourSalary;
    private double myProfit;

    private Kitchen kitchen;


    //region CONSTRUCTORS GETTERS AND SETTERS
    public Chef() {
    }

    public Chef(String name, String lastName, String dateOfBrith, Integer id, String userName, String password, double hourSalary) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }

    public double getMyProfit(){
          return this.myProfit;
    }


    //endregion


    @Override
    public String toString() {
        return super.toString() + "Chef{" +
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
        System.out.println("3. Agregar stock");
        System.out.println("4. Ver informacion de la cocina");
        System.out.println("5. Salir");
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
                    case 2 , 5:
                        double salaryDay = super.clockOut();
                        EmployeeFile employeeFile = new EmployeeFile();
                        employeeFile.saveMeChef(this, salaryDay);
                        exit = true;
                        exit(0);
                        break;
                    case 3:
                        this.kitchen.changeStock();
                        break;
                    case 4:
                        System.out.println(this.kitchen.toString());
                        break;
                }
            } while (!exit);
        }catch (IOException e){
            System.out.println("Error al guardar");
        }finally {
            System.out.println("Gracias por usar nuestro sistema");
        }

    }
}
