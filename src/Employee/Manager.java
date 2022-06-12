package Employee;

import Files.EmployeeFile;
import Files.RestoFiles;
import Files.TicketFile;
import Restaurant.Lounge;
import Restaurant.Ticket;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Manager extends Employee implements Menus, EmployeeTask {
    private Double hourSalary;
    private Boolean inEmergency = false;

    private Lounge lounge;


    RestoFiles restoFiles;

    Employee employeeFile;

    List<Employee> myEmployeeList;

    //region CONSTRUCTORS GETTERS AND SETTERS
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

    public void setMyEmployeeList(List<Employee> myEmployeeList) {
        this.myEmployeeList = myEmployeeList;
    }

    public Employee getEmployeeFile() {
        return employeeFile;
    }

    //endregion
    public Employee searchEmployee(Integer id) {
        for (Employee employee : myEmployeeList) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
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
                case 5 -> {
                    this.lounge.takeOrder();
                    break;
                }
                case 6 -> {
                    this.lounge.tableToCollect();
                    break;
                }
                case 7 ->  {
                    System.out.println("La ganacia total hasta el momento es: " + getTotalProfit());

                    break;
                }
                        case 8 -> {
                    System.out.println("En desarrollo");
                    break;
                }
                case 9 -> {
                    lounge.tableOperations();
                    break;
                }
                case 10 -> {
                    deleteEmployee();
                    break;
                }

                case 11 -> exit(0);
            }
        } while (op > 0 && op < 12);
    }

    public void deleteEmployee() {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Ingrese el id del empleado que desea eliminar");
            Integer id = sc.nextInt();
            Employee employee = searchEmployee(id);
            if (employee != null) {
                EmployeeFile employeeFile = new EmployeeFile();
                employeeFile.deleteEmployee(employee);
                System.out.println("El empleado ha sido eliminado");
            } else {
                System.out.println("El empleado no existe");
            }
        } catch (Exception e) {
            System.out.println("El id ingresado no es valido");
        }
    }

    public void addEmployee() throws IOException {
        Kitchener newEmployee = new Kitchener("Kevin", "Reynoso", LocalDate.of(1999, 3, 9).toString(),
                43567798, "kevin", "123", Salarys.MANAGER.getSalary());
        try {
            EmployeeFile employeeFile = new EmployeeFile();
            employeeFile.writeFile(newEmployee);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
            exit(0);
        }
    }
    private double getTotalProfit(){
        TicketFile ticketFile = new TicketFile();
        List<Ticket> ticketList = ticketFile.getTicketList();
        double totalProfit = 0;
        for (Ticket ticket : ticketList) {
            totalProfit += ticket.getPrice();
        }
        return totalProfit;
    }

    @Override
    public void showMenu() {
        System.out.println("1. Fichar entrada");
        System.out.println("2. Fichar salida");
        System.out.println("3. Reservar mesa");
        System.out.println("4. Agregar empleados");
        System.out.println("5. Tomar pedidos");
        System.out.println("6. Cobrar mesa");
        System.out.println("7. Ganancia total");
        System.out.println("8. Cancelar reserva");
        System.out.println("9. Ver mesas");
        System.out.println("10. Eliminar empleado");
        System.out.println("11. Salir");

    }


}

