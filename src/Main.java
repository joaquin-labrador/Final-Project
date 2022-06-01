import Employee.*;
import Restaurant.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import javax.print.attribute.HashPrintJobAttributeSet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //AppResto resto = new AppResto("La marquesita");
        //System.out.println(resto.getRestoEmployee());
        readJsonResto();

    }
    public static void readJsonResto() throws IOException {
        List<Beverages> beverages = new ArrayList<>();
        Beverages b1 = new Beverages(200, "Coca-Cola", 100);
        Beverages b2 = new Beverages(200, "Sprite", 55);
        Beverages b3 = new Beverages(200, "Fanta", 70);
        Beverages b5 = new Beverages(250, "Coca-Cola Zero", 100);
        Beverages b6 = new Beverages(250, "Sprite Zero", 20);
        Beverages b7 = new Beverages(250, "Fanta Zero", 10);
        Beverages b8 = new Beverages(500, "Vino Tinto de la casa", 200);
        Beverages b9 = new Beverages(500, "Vino Blanco de la casa", 200);
        Beverages b10 = new Beverages(300, "Cerveza quilmes", 250);

        beverages.add(b1);
        beverages.add(b2);
        beverages.add(b3);
        beverages.add(b5);
        beverages.add(b6);
        beverages.add(b7);
        beverages.add(b8);
        beverages.add(b9);
        beverages.add(b10);




        //add menu to listingredientes

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter inPut = null;
        try {
            inPut = new BufferedWriter(new FileWriter("JSONFilesResto\\beverages.json"));
            inPut.write(gson.toJson(beverages));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inPut.close();
        }















    }

}

/*
 *Escribir archvos por seperado y despues añadirlos al arrayList
 *  */

