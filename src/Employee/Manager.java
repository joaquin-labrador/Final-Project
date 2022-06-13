package Employee;

import Files.EditRestoFile;
import Files.EmployeeFile;
import Files.RestoFiles;
import Files.TicketFile;
import Restaurant.Kitchen;
import Restaurant.Lounge;
import Restaurant.Ticket;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Manager extends Employee implements EmployeeInterface {
    private Double hourSalary;

    private Lounge lounge;


    RestoFiles restoFiles;

    EmployeeFile employeeFile;

    List<Employee> myEmployeeList = null;

    Kitchen kitchen;

    private double myProfit;

    //region CONSTRUCTORS GETTERS AND SETTERS


    public Manager() {
        this.myProfit = 0;
    }

    public Manager(String name, String lastName, String dateOfBrith, Integer id, String userName, String password, Double hourSalary) {
        super(name, lastName, dateOfBrith, id, userName, password);
        this.hourSalary = hourSalary;
        this.myProfit = 0;

    }

    public void setMyEmployeeList(List<Employee> myEmployeeList) {
        this.myEmployeeList = myEmployeeList;
    }
    public Double getHourSalary() {
        return hourSalary;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public void setHourSalary(Double hourSalary) {
        this.hourSalary = hourSalary;
    }


    public void setLounge(Lounge lounge) {
        this.lounge = lounge;
    }

    public Lounge getLounge() {
        return lounge;
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
                "hourSalary=" + hourSalary + "\n" +
                '}';
    }

    @Override
    public void employeeOperations() throws IOException {
        try {
            int op;
            Scanner sc = new Scanner(System.in);
            boolean exit = false;
            showMenu();

            do {
                op = sc.nextInt();
                switch (op) {
                    case 1 -> {
                        super.clockIn();
                        System.out.println(toString());
                        break;
                    }
                    case 2, 13 -> {
                        double hoursWorked = super.clockOut();
                        this.employeeFile = new EmployeeFile();
                        this.employeeFile.saveMeManager(this, hoursWorked);
                        exit = true;
                        exit(0);
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
                    case 7 -> {
                        System.out.println("La ganacia total hasta el momento es: " + getTotalProfit());

                        break;
                    }
                    case 8 -> {
                        lounge.cancelBookedTable();
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
                    case 11 -> {
                        operationEditPrice();
                        break;
                    }
                    case 12 ->{
                        operationViewEmployee();
                        break;
                    }


                }
            } while (!exit);
        } catch (IOException e) {
            System.out.println("Error al guardar el empleado");
        } finally {
            System.out.println("Gracias por usar el sistema");
        }
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

    private double getTotalProfit() {
        TicketFile ticketFile = new TicketFile();
        List<Ticket> ticketList = ticketFile.getTicketList();
        double totalProfit = 0;
        for (Ticket ticket : ticketList) {
            totalProfit += ticket.getPrice();
        }
        return totalProfit;
    }

    @Override
    public void calculateProfit(double hours) {
        this.myProfit += (hours * hourSalary);
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
        System.out.println("11. Editar precios");
        System.out.println("12. Ver trabajadores del restaurante");
        System.out.println("13. Salir");

    }

    private void operationEditPrice() {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        boolean exit = false;
        System.out.println(menuEditPrice());
        do {
            op = sc.nextInt();
            try {

                switch (op) {
                    case 0 -> {
                        exit = true;
                        break;
                    }
                    case 1 -> {
                        editMenuPrice();
                        exit = true;
                        break;
                    }
                    case 2 -> {
                        editBeveragesPrice();
                        exit = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("El id ingresado no es valido");
            }

        } while (!exit);
    }

    private void editMenuPrice() {
        int op;
        Scanner sc = new Scanner(System.in);
        EditRestoFile editRestoFile = new EditRestoFile();
        System.out.println("Seleccione un menu a editar el precio");
        System.out.println(lounge.getMenu().toString());
        op = sc.nextInt();

        try {
            if (op > this.lounge.getMenu().size()) {
                System.out.println("El menu no existe");
            } else {
                System.out.println("Ingrese el nuevo precio");
                double price = sc.nextDouble();
                editRestoFile.saveNewPriceMenu(op, price);
                System.out.println("El precio ha sido editado");
            }

        } catch (Exception e) {
            System.out.println("El numero ingresado no es valido");
        }


    }

    private void editBeveragesPrice() {
        EditRestoFile editRestoFile = new EditRestoFile();
        int op;
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione un bebida a editar el precio");
        System.out.println(lounge.getBeverages().toString());
        op = sc.nextInt();

        try {

            if (op > this.lounge.getBeverages().size()) {
                System.out.println("La bebida no existe");
            } else {
                System.out.println("Ingrese el nuevo precio");
                double price = sc.nextDouble();
                editRestoFile.saveNewPriceBeverage(op, price);
                System.out.println("El precio ha sido editado");

            }


        } catch (Exception e) {
            System.out.println("El numero ingresado no es valido");
        }

    }

    private String menuEditPrice() {
        return """
                Elige una opcion:\s
                1- Editar precio de un menu\s
                2- Editar precio de una bebida\s
                0- Volver\s
                """;

    }
    private String menuViewEmployee() {
        return """
                Elige una opcion:\s
                1- Ver trabajadores del salon\s
                2- Ver trabajadores de la cocina\s
                3- Ver managers\s
                0- Volver\s
                """;
    }

    private void operationViewEmployee() {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        boolean exit = false;
        System.out.println(menuViewEmployee());
        do {
            if(op != 0)
                System.out.println("Seguir viendo eligue una opcion");
            op = sc.nextInt();
            try {

                switch (op) {
                    case 0 -> {
                        exit = true;
                        break;
                    }
                    case 1 -> {
                        System.out.println(lounge.getEmployees().toString());
                        break;
                    }
                    case 2 -> {
                        System.out.println(kitchen.getKitchenEmployee().toString());
                        break;
                    }
                    case 3 -> {
                        showManager();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error");
            }

        } while (!exit);
    }

    private void showManager(){
        for (Employee employee : this.myEmployeeList) {
            if (employee instanceof Manager) {
                System.out.println(employee.toString());
            }
        }
    }


}

