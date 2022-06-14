package Employee;

import java.util.Scanner;

public class AddEmployee {
    public AddEmployee() {
    }

    public Chef addChef() {
        Chef chef = new Chef();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        chef.setName(scanner.nextLine());
        System.out.println("Enter last name: ");
        chef.setLastName(scanner.nextLine());
        System.out.println("Enter date of birth: (yyyy-mm-dd)");
        chef.setDateOfBrith(scanner.nextLine());
        System.out.println("Enter id: ");
        chef.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter user name: ");
        chef.setUserName(scanner.nextLine());
        System.out.println("Enter password: ");
        chef.setPassword(scanner.nextLine());
        chef.setHourSalary(Salarys.CHEF.getSalary());

        return chef;

    }

    public Manager addManager() {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        manager.setName(scanner.nextLine());
        System.out.println("Enter last name: ");
        manager.setLastName(scanner.nextLine());
        System.out.println("Enter date of birth: (yyyy-mm-dd)");
        manager.setDateOfBrith(scanner.nextLine());
        System.out.println("Enter id: ");
        manager.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter user name: ");
        manager.setUserName(scanner.nextLine());
        System.out.println("Enter password: ");
        manager.setPassword(scanner.nextLine());
        manager.setHourSalary(Salarys.MANAGER.getSalary());
        ;
        return manager;

    }

    public Server addServer() {
        Server server = new Server();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        server.setName(scanner.nextLine());
        System.out.println("Enter last name: ");
        server.setLastName(scanner.nextLine());
        System.out.println("Enter date of birth: (yyyy-mm-dd)");
        server.setDateOfBrith(scanner.nextLine());
        System.out.println("Enter id: ");
        server.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter user name: ");
        server.setUserName(scanner.nextLine());
        System.out.println("Enter password: ");
        server.setPassword(scanner.nextLine());
        server.setHourSalary(Salarys.SERVER.getSalary());
        return server;
    }
    public Host addHost() {
        Host host = new Host();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        host.setName(scanner.nextLine());
        System.out.println("Enter last name: ");
        host.setLastName(scanner.nextLine());
        System.out.println("Enter date of birth: (yyyy-mm-dd)");
        host.setDateOfBrith(scanner.nextLine());
        System.out.println("Enter id: ");
        scanner.nextLine();
        host.setId(scanner.nextInt());
        System.out.println("Enter user name: ");
        host.setUserName(scanner.nextLine());
        System.out.println("Enter password: ");
        host.setPassword(scanner.nextLine());
        host.setHourSalary(Salarys.HOST.getSalary());
        return host;
    }
    public Kitchener addKitchener() {
        Kitchener kitchener = new Kitchener();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        kitchener.setName(scanner.nextLine());
        System.out.println("Enter last name: ");
        kitchener.setLastName(scanner.nextLine());
        System.out.println("Enter date of birth: (yyyy-mm-dd)");
        kitchener.setDateOfBrith(scanner.nextLine());
        System.out.println("Enter id: ");
        scanner.nextLine();
        kitchener.setId(scanner.nextInt());
        System.out.println("Enter user name: ");
        kitchener.setUserName(scanner.nextLine());
        System.out.println("Enter password: ");
        kitchener.setPassword(scanner.nextLine());
        kitchener.setHourSalary(Salarys.KITCHENER.getSalary());
        return kitchener;
    }
}
