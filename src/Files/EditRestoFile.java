package Files;

import Restaurant.Beverages;
import Restaurant.Menu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EditRestoFile {

    public EditRestoFile() {
    }

    public void saveNewPriceMenu(int menu, double price) {
        BufferedReader reader = null;
        BufferedWriter bufferedWriter = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Menu> menuListAux = new ArrayList<>();
        int op = menu - 1;
        try {
            reader = new BufferedReader(new FileReader("JSONFilesResto\\menu.json"));
            menuListAux = gson.fromJson(reader,
                    (new TypeToken<List<Menu>>() {
                    }.getType()));
            menuListAux.get(op).setPrice(price);
            bufferedWriter = new BufferedWriter(new FileWriter("JSONFilesResto\\menu.json"));
            gson.toJson(menuListAux, bufferedWriter);
            System.out.println("Menu saved");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bufferedWriter != null;
            try {
                bufferedWriter.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveNewPriceBeverage(int beverage, double price) {
        BufferedReader reader = null;
        BufferedWriter bufferedWriter = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Beverages> beveragesAux = new ArrayList<>();
        int op = beverage - 1;
        try {
            reader = new BufferedReader(new FileReader("JSONFilesResto\\beverages.json"));
            beveragesAux = gson.fromJson(reader,
                    (new TypeToken<List<Beverages>>() {
                    }.getType()));
            beveragesAux.get(op).setPrice(price);
            bufferedWriter = new BufferedWriter(new FileWriter("JSONFilesResto\\beverages.json"));
            gson.toJson(beveragesAux, bufferedWriter);
            System.out.println("Beverage saved");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bufferedWriter != null;
            try {
                bufferedWriter.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
