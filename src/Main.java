import Employee.*;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        AppResto resto = new AppResto("La marquesita");
        Employee user = null;
        String userName = null;
        String password = null;
        try {
            do {
                if(userName != null || password != null) {
                    System.out.println("Contraseña incorrecta o usuario no existe");
                }
                System.out.println("Ingrese su nombre de usuario: ");
                userName = scanner.nextLine();
                System.out.println("Ingrese su contraseña: ");
                password = scanner.nextLine();
                user = resto.signIn(userName, password);
                
            } while (user == null);
            } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        resto.userOptions(user);
        System.out.println("Gracias por utilizar mi software");
        System.out.println("By Joaquin Labrador");


    }
}


