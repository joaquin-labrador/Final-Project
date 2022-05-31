package Files;


import Employee.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeFile implements FilesOperations{
    List<Employee> employeeList;

    public EmployeeFile() {
        readFile();
    }

    @Override
    public void readFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Employees.json"));
            this.employeeList = gson.fromJson(reader,
                    (new TypeToken<List<Employee>>() {}.getType()));
            reader.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void writeFile() {

    }

    @Override
    public void showFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Employees.json"));
            System.out.println(reader);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
