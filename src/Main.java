import Employee.*;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AppResto resto = new AppResto("La marquesita");
       // System.out.println(resto.getRestoEmployee());
       // System.out.println(resto.getBeveragesList());

        Employee user;

        user = resto.signIn("kitchenerMatias", "67sdafdf@-3");

        resto.userOptions(user);






    }
}

/*
 *Escribir archvos por seperado y despues añadirlos al arrayList
 *  */

