package Restaurant;

import Employee.*;
import Files.TicketFile;

import java.util.*;

public class Lounge implements LoungueTask {
    private List<Ticket> ticketList = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Menu> menu = new ArrayList<>();
    private List<Beverages> beverages = new ArrayList<>();


    //region Constructors and Getters and Setters
    public Lounge() {
    }

    public Lounge(Map<Integer, Table> tables, List<Menu> menu, List<Beverages> beverages, List<Ticket> tickets) {
        this.tables = tables;
        this.menu = menu;
        this.beverages = beverages;
        this.ticketList = tickets;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setRestoEmployee(List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee instanceof Host || employee instanceof Server) {
                {
                    this.employees.add(employee);
                }
            }


        }
    }

    public Map<Integer, Table> getTables() {
        return tables;
    }

    public void setTables(Map<Integer, Table> tables) {
        this.tables = tables;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<Beverages> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<Beverages> beverages) {
        this.beverages = beverages;
    }

    //endregion
    @Override
    public String toString() {
        return "Lounge{" + "employees=" + employees + ", tables=" + tables + ", menu=" + menu + ", beverages=" + beverages + '}';
    }
    public void tableOperations() {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do {
            try {
                System.out.println(menuTable());
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        showAvailableTables();
                        break;
                    case 2:
                        showAllTables();
                        break;
                    case 3:
                        showActiveTickets();
                        break;
                    case 4:
                        showBookedTables();
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error ingresaste un caracter no valido");
            }
        } while (op != 0);
    }

    //region Methods book table and cancel table
    @Override
    public void reserveTable() {
        boolean isBooking = false;
        Scanner sc = new Scanner(System.in);
        int table = 0;
        int people = 0;
        int op = 0;
        do {
            try {
                System.out.println("Ingrese el numero de la mesa a reservar : ");
                table = sc.nextInt();
                System.out.println("Ingrese la cantidad de comensales : ");
                people = sc.nextInt();
                isBooking = bookTable(table, people);
            } catch (InputMismatchException e) {
                System.out.println("Error ingresaste un caracter no valido");
                isBooking = true;
            } finally {
                if (isBooking) {
                    try {
                        System.out.println("Desea no reservar otra mesa? (Ingrese 1 para otra reservar otra mesa)");
                        op = sc.nextInt();
                        if (op == 1) {
                            isBooking = false;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error ingresaste un caracter no valido");
                    }
                }
            }


        } while (!isBooking);
    }

    @Override
    public boolean bookTable(int tableNumber, int capacity) {
        if (tableNumber > 0 && tableNumber <= tables.size()) {
            for (Map.Entry<Integer, Table> table : tables.entrySet()) {
                if (table.getValue().getNumber() == tableNumber) {
                    if (table.getValue().getCapacity() >= capacity) {
                        table.getValue().setCapacity(capacity);
                        table.getValue().setOccupied();
                        return true;
                    } else {
                        System.out.println("No hay suficiente capacidad para la cantidad de comensales");
                        return false;
                    }
                }
            }
        } else System.out.println("Table not found");
        return false;
    }


    public void cancelBookedTable() {
        showBookedTables();
        int tableNumber = selectNumberTable();
        for (Map.Entry<Integer, Table> table : tables.entrySet()) {
            if (table.getValue().getNumber() == tableNumber) {
                if (table.getValue().getFoodOfTable() == null || table.getValue().getBeveragesOfTable() == null) {
                    table.getValue().setAvailable();
                    System.out.println("Reserva cancelada");
                } else {
                    System.out.println("Esta mesa tienen comensales, no se puede cancelar");
                }
            }
        }
    }
    //endregion

    //region Methods doTakeOrder Menu and beverages
    public int selectNumberTable() {
        Scanner sc = new Scanner(System.in);
        int table = 0;
        do {
            try {
                System.out.println("Seleccione la mesa: ");
                table = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error ingresaste un caracter no valido");
            }
        } while (table <= 0 || table > tables.size() && !this.tables.get(table).isAvailable());
        return table;
    }

    public void takeOrder() {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        int table = 0;
        int cont = 0;
        List<Integer> numbersOfMenu = new ArrayList<>();
        table = selectNumberTable();

        System.out.println(menuTakeOrder().toString());
        do {
            try {
                op = sc.nextInt();
                if (op > 0 && op <= menu.size()) {
                    numbersOfMenu.add(op);
                } else {
                    System.out.println("Ingrese un numero valido");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error ingresaste un caracter no valido");
            }
            System.out.println("Desea tomar otro pedido? (Ingrese 1 para tomar otro pedido)");
            cont = sc.nextInt();
        } while (cont == 1);
        doTakeOrder(table, numbersOfMenu);


    }

    @Override
    public void doTakeOrder(int tableNumber, List<Integer> numbersOfMenu) {
        List<Menu> menuAux = new ArrayList<>();
        menuAux = searchMenu(numbersOfMenu);

        //for each hashmap table
        if (menuAux != null) {
            for (Map.Entry<Integer, Table> table : tables.entrySet()) {
                if (table.getValue().getNumber() == tableNumber) {
                    table.getValue().setFoodOfTable(menuAux);
                    table.getValue().setTotalPrice(menuAux);
                    takeBeverage(tableNumber);
                    table.getValue().setOccupied();
                }
            }
        } else {
            System.out.println("No se encontro el menu");
        }

    }

    public void takeBeverage(int tableNumber) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        System.out.println(menuBaverage().toString());
        List<Integer> numbersOfBeverage = new ArrayList<>();
        boolean isTaked = false;
        do {
            try {
                if (op != 0) System.out.println("Ingrese otra bebida. 11- para terminar");
                op = sc.nextInt();
                if (op > 0 && op <= beverages.size()) numbersOfBeverage.add(op);
                else if (op == 11) {
                    System.out.println("");
                    isTaked = true;
                } else System.out.println("Numero no validos");
            } catch (InputMismatchException e) {
                System.out.println("Error ingresaste un caracter no valido");
            }
        } while (!isTaked);
        doTakeBeverage(tableNumber, numbersOfBeverage);

    }


    public void doTakeBeverage(int tableNumber, List<Integer> numbersOfBeverage) {
        List<Beverages> beveragesAux = new ArrayList<>();
        beveragesAux = searchBeverages(numbersOfBeverage);
        if (beveragesAux != null) {
            for (Map.Entry<Integer, Table> table : tables.entrySet()) {
                if (table.getValue().getNumber() == tableNumber) {
                    table.getValue().setBeveragesOfTable(beveragesAux);
                    table.getValue().setTotalPriceBeverages(beveragesAux);
                }
            }
        }
    }
    //  endregion

    //region Methods searchMenu and searchBeverages
    private List<Menu> searchMenu(List<Integer> numbersOfMenu) {
        List<Menu> menuAux = new ArrayList<>();
        for (Integer ofMenu : numbersOfMenu) {
            for (Menu menu : menu) {
                if (menu.getId() == ofMenu) {
                    menuAux.add(menu);
                }
            }
        }
        if (menuAux.size() == 0) {
            System.out.println("No se encontro el menu");
            return null;
        }
        return menuAux;
    }

    private List<Beverages> searchBeverages(List<Integer> numbersOfBeverage) {
        List<Beverages> beveragesAux = new ArrayList<>();
        for (Integer ofBeverage : numbersOfBeverage) {
            for (Beverages beverages : beverages) {
                if (beverages.getId() == ofBeverage) {
                    beveragesAux.add(beverages);
                }
            }
        }
        if (beveragesAux.size() == 0) {
            System.out.println("No se encontro el bebida");
            return null;
        }
        return beveragesAux;
    }

    //endregion

    //region Methods saveTickets and collectTickets
    public void tableToCollect() {
        Scanner sc = new Scanner(System.in);
        showActiveTickets();
        int n = selectNumberTable();
        int op = 0;
        boolean isCollect = false;
        for (Map.Entry<Integer, Table> table : tables.entrySet()) {
            if (table.getValue().getNumber() == n) {
                System.out.println("Total a pagar : " + table.getValue().getTotalPrice());
                System.out.println("Se recibio el pago? (Ingrese 1 para recibir el pago)");
                op = sc.nextInt();
                if (op == 1) {
                    System.out.println("Dinero cobrado" + table.getValue().getTotalPrice());
                    generateTicket(table.getValue(), table.getValue().getTotalPrice());
                    isCollect = true;
                    table.getValue().setAvailable();
                } else {
                    System.out.println("No se recibio el pago");
                }
            }
        }
        if (isCollect) {
            System.out.println("Ticket cobrado");

        } else {
            System.out.println("No se encontro la mesa");
        }
    }

    private void generateTicket(Table table, double totalPrice) {
        TicketFile ticketFile = new TicketFile();
        Ticket ticket = new Ticket(totalPrice);
        table.setAvailable();
        System.out.println("Ticket generado");
        ticketFile.saveTicket(ticket);

    }

    //endregion

    //region Methods Shows Information and Menus

    public void showAvailableTables() {
        for (Map.Entry<Integer, Table> table : tables.entrySet()) {
            if (table.getValue().isAvailable()) {
                System.out.println(table.getValue().toString());
            }
        }
    }

    public void showAllTables() {
        for (Map.Entry<Integer, Table> table : tables.entrySet()) {
            System.out.println(table.getValue().toString());
        }
    }

    public void showActiveTickets() {
        for (Map.Entry<Integer, Table> table : tables.entrySet()) {
            if (table.getValue().getTotalPrice() != 0) {
                System.out.println(table.getValue().showTicket());
            }
        }
    }

    public void showBookedTables() {
        for (Map.Entry<Integer, Table> table : tables.entrySet()) {
            if (!table.getValue().isAvailable()) {
                System.out.println(table.getValue().toString());
            }
        }
    }

    public void showAllBeverages() {
        for (Beverages beverages : beverages) {
            System.out.println(beverages.toString());
        }
    }

    public void showMenu() {
        for (Menu menu : this.menu) {
            System.out.println(menu.toString());
        }
    }

    private String menuTable() {

        return """
                Elige una opcion :\s
                1. Ver mesas disponibles\s
                2. Ver todas las mesas\s
                3. Ver tickets activos\s
                4. Ver mesass ocupadas\s
                0. Salir\s
                 """;

    }

    public String menuTakeOrder() {
        return """
                Ingrese el numero de menu que desea tomar :\s
                1.Tortilla de papa\s
                2.Bife con pure de papa\s
                3.Papas fritas\s
                4.Papas fritas con queso cheddar\s
                5 Milanesa de Pollo con pure de papa\s
                6.Costillitas de cerdo a la barbacoa\s
                """;
    }

    public String menuBaverage() {
        return """
                Ingrese el numero de bebida que desea tomar :\s
                1.Coca-cola\s
                2.Fanta\s
                3.Sprite\s
                4.Coca-cola zero\s
                5.Fanta zero\s
                6.Sprite zero\s
                7.Vino tinto\s
                8.Vino blanco\s
                9.Cerveza\s
                10.Agua\s
                11.Salir\s
                """;
    }
    //endregion
}

