package Employee;

import Files.EmployeeFile;
import Restaurant.Lounge;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Host extends Employee implements EmployeeInterface {


    private double hourSalary;

    private double tips;

    private Lounge lounge;

    private double myProfit;

    // region CONSTRUCTORS GETTERS AND SETTERS
    public Host() {
    }

    public Host(String name, String lastName, String dateOfBrith, Integer id, String userName, String password, double hourSalary) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;
        this.tips = 0;
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
        this.tips = tips;
    }

    public double getMyProfit() {
        return myProfit;
    }
//endregion

    @Override
    public String toString() {
        return super.toString() + "Host{" +
                "hourSalary=" + hourSalary +
                ", tips=" + tips + "\n" +
                '}';
    }


    @Override
    public void calculateProfit(double hours) {
        this.myProfit += ((hours * this.hourSalary) + this.tips);
    }

    @Override
    public void showMenu() {

        System.out.println("Selecciona una opcion: ");
        System.out.println("1. Fichar entrada");
        System.out.println("2. Fichar salida");
        System.out.println("3. Reservar mesa");
        System.out.println("4. Cancelar reserva");
        System.out.println("5. Ver mesas");
        System.out.println("6. Salir");

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
                    case 2, 6:
                        double daySalary = super.clockOut();
                        EmployeeFile file = new EmployeeFile();
                        file.saveMeHost(this, daySalary);
                        exit(0);
                        break;
                    case 3:
                        this.lounge.reserveTable();
                        break;
                    case 4:
                        this.lounge.cancelBookedTable();
                        break;
                    case 5:
                        this.lounge.tableOperations();
                        break;
                }
            } while (op > 0 && op < 4);

        } catch (IOException e) {
            System.out.println("Error al guardar");
        } finally {
            System.out.println("Gracias por usar nuestro servicio");
            exit(0);
        }

    }
}
