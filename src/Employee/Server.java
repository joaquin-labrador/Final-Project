package Employee;

import Files.EmployeeFile;
import Restaurant.Lounge;

import java.io.IOException;
import java.util.Scanner;

import static Files.WriteNewEmployees.changePassword;
import static java.lang.System.exit;

public class Server extends Employee
        implements EmployeeInterface {

    private double hourSalary;

    private double tips;

    private double myProfit;

    private Lounge lounge;

    //region CONSTRUCTORS GETTERS AND SETTERS
    public Server() {

    }

    public Server(String name, String lastName, String dateOfBrith, Integer id, String userName, String password, double hourSalary) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;

    }

    public double getMyProfit() {
        return myProfit;
    }

    public Lounge getLounge() {
        return lounge;
    }

    public void setLounge(Lounge lounge) {
        this.lounge = lounge;
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
        this.tips += tips;
    }
//endregion

    @Override
    public String toString() {
        return super.toString() + "Server{" +
                "hourSalary=" + hourSalary +
                ", tips=" + tips + "\n" +
                '}';
    }

    @Override
    public void calculateProfit(double hours) {
        this.myProfit += ((this.hourSalary * hours) + this.tips);
    }

    @Override
    public void showMenu() {
        System.out.println("Selecciona una opcion: ");
        System.out.println("1. Fichar entrada");
        System.out.println("2. Fichar salida");
        System.out.println("3. Tomar pedidos ");
        System.out.println("4. Ver Mesas");
        System.out.println("5. Combrar una mesa");
        System.out.println("6. Sumar mi propina");
        System.out.println("7. Cambiar contraseña");
        System.out.println("8. Salir");
    }

    @Override
    public void employeeOperations() throws IOException {
        try {
            int op;
            Scanner sc = new Scanner(System.in);
            int tips = 0;
            double hoursWork = 0;
            boolean exit = false;
            do {
                showMenu();
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        super.clockIn();
                        break;
                    case 2:
                    case 8:
                        hoursWork = super.clockOut();
                        calculateProfit(hoursWork);
                        EmployeeFile file = new EmployeeFile();
                        file.saveMeServer(this, hoursWork);
                        exit(0);
                        break;
                    case 3:
                        this.lounge.takeOrder();
                        break;
                    case 4:
                        this.lounge.tableOperations();
                        break;
                    case 5:
                        this.lounge.tableToCollect();
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad de propina: ");
                        tips = sc.nextInt();
                        this.setTips(tips);
                        break;
                    case 7:
                        changePassword(this);


                }
            } while (op > 0 && op < 5);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Gracias por su visita");
            exit(0);
        }
    }

}
