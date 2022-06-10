import Employee.*;
import Restaurant.Table;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        AppResto resto = new AppResto("La marquesita");
        Employee user;

        user = resto.signIn("managerMaximo", "34324esds3");
        resto.userOptions(user);


    }
}

