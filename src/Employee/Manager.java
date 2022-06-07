package Employee;

import Files.EmployeeFile;
import Files.RestoFiles;
import Restaurant.Lounge;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;

public class Manager extends Employee implements Menus, EmployeeTask {
    private Double hourSalary;
    private Boolean inEmergency = false;

    private Lounge lounge;


    RestoFiles restoFiles;


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
    public void employeeOperations() throws IOException {
        int op;
        Scanner sc = new Scanner(System.in);
        do {
            showMenu();
            op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    super.clockIn();
                    System.out.println(toString());
                    break;
                }
                case 2 -> {
                    super.clockOut();
                    System.out.println(toString());
                    break;
                }
                case 3 -> {
                    lounge.reserveTable();
                    break;
                }
                case 4 -> {
                    addEmployee();
                    break;
                }
                case 5, 6, 7, 8 -> {
                    System.out.println("En desarrollo");
                    break;
                }
                case 9 -> {
                    System.out.println(lounge.getTables().toString());
                    break;
                }

                case 10 -> exit(0);
            }
        } while (op > 0 && op < 11);
    }

    public void addEmployee() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(menuAddEmployee());
        int op = sc.nextInt();
        try {
            EmployeeFile employeeFile = new EmployeeFile();
           Host newEmployee = new Host("Kevin", "Reynoso", LocalDate.of(1999, 3, 9).toString(),
                    43567798, "kevin", "123", Salarys.MANAGER.getSalary());
            switch (op) {
                case 1:
                    employeeFile.writeFile(newEmployee);
                    break;
                case 2:
                    employeeFile.writeFile(newEmployee);
                    break;
                case 3:
                    employeeFile.writeFile(newEmployee);
                    break;
                case 4:
                    employeeFile.writeFile(newEmployee);
                    break;
                case 5:
                    employeeFile.writeFile(newEmployee);
                    exit(0);

            }

        }catch (IOException e){
            System.out.println("Error al escribir en el archivo");
        }



    }


    public String menuAddEmployee() {
        Scanner sc = new Scanner(System.in);
        return "Ingrese que tipo de empleado desea agregar: \n" +
                "1. Manager\n" +
                "2. Chef\n" +
                "3. Kitchener\n" +
                "4. Host\n" +
                "5. Server\n" +
                "6. Exit\n";
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



}