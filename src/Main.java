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
        AppResto resto = new AppResto("La marquesita");
        //System.out.println(resto.getRestoEmployee());
        System.out.println(resto.getBeveragesList());





    }

}

/*
 *Escribir archvos por seperado y despues añadirlos al arrayList
 *  */

