import Employee.*;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AppResto resto = new AppResto("La marquesita");
        try {
            Employee user;
            user = resto.signIn("kitchenerMatias", "67sdafdf@-3");
            resto.userOptions(user);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Gracias por utilizar mi software");
        System.out.println("By Joaquin Labrador");


    }
}

/*
 *Escribir archvos por seperado y despues añadirlos al arrayList
 *  */

