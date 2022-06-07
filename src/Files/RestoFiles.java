package Files;

import Restaurant.Beverages;
import Restaurant.Food;
import Restaurant.Menu;
import Restaurant.Table;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestoFiles implements FilesOperations {
    private List<Beverages> beveragesList = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();
    private List<Menu> menuList = new ArrayList<>();
    private List<Table> tableList = new ArrayList<>();

    public RestoFiles() throws IOException {
        readFile();

    }


    @Override
    public void readFile() throws IOException {
        BufferedReader readerBeverages = null;
        BufferedReader readerFood = null;
        BufferedReader readerMenu = null;
        BufferedReader readerTable = null;
        try {
            //region Read File
            readerBeverages = new BufferedReader(new FileReader("JSONFilesResto\\beverages.json"));
            readerFood = new BufferedReader(new FileReader("JSONFilesResto\\foodStock.json"));
            readerMenu = new BufferedReader(new FileReader("JSONFilesResto\\menu.json"));
            readerTable = new BufferedReader(new FileReader("JSONFilesResto\\tables.json"));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            this.beveragesList = gson.fromJson(readerBeverages,
                    (new TypeToken<List<Beverages>>() {}.getType()));
            this.foodList = gson.fromJson(readerFood,
                    (new TypeToken<List<Food>>() {}.getType()));
            this.menuList = gson.fromJson(readerMenu,
                    (new TypeToken<List<Menu>>() {}.getType()));
            this.tableList = gson.fromJson(readerTable,
                    (new TypeToken<List<Table>>() {}.getType()));
            //endregion
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //region Close File
            assert readerBeverages != null;
            readerBeverages.close();
            assert readerFood != null;
            readerFood.close();
            assert readerMenu != null;
            readerMenu.close();
            assert readerTable != null;
            readerTable.close();
            //endregion
        }
    }

    public List<Beverages> getBeveragesList() {
        return beveragesList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public List<Table> getTableList() {
        return tableList;
    }



    @Override
    public void showFile() {

    }
}
