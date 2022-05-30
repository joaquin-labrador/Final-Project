import Employee.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        Chef chef1 = new Chef("Joaquin", "Labrador", LocalDate.of(1998, 11, 6),
                41458511, "chefJoaquin", "123gf45", Salarys.CHEF.getSalary());
        Kitchener kitchener1 = new Kitchener("Matias", "Aceval", LocalDate.of(2001, 12, 12), 43567654,
                "kitchenerMatias", "67sdafdf@-3", Salarys.KITCHENER.getSalary());
        Manager manager1 = new Manager("Maximo", "Torterolo", LocalDate.of(2002, 6, 23),
                44533543, "managerMaximo", "34324esds3", Salarys.SERVER.getSalary());
        Host host1 = new Host("Santiago","Pavon", LocalDate.of(2002,4,23),
                43578956,"hostSantiago","23123423Hb2343",Salarys.HOST.getSalary());
        Server server1 = new Server("Agustin","Gomes",LocalDate.of(1998,9,29),41234234,
                "serverAgustin","@dfd678",Salarys.SERVER.getSalary());
        Server server2 = new Server("Matias","Fierro", LocalDate.of(1996,2,23),39455959,
                "serverMatias", "ebfe@45", Salarys.SERVER.getSalary());

        employeeList.add(chef1);
        employeeList.add(kitchener1);
        employeeList.add(manager1);
        employeeList.add(host1);
        employeeList.add(server1);
        employeeList.add(server2);

        JSONArray employeeListJson = new JSONArray();

        for (Employee a : employeeList) {
            employeeListJson.put(a);
        }

        System.out.println(employeeListJson.toString());

        try(FileWriter file = new FileWriter("Employees.json")){
            file.write(employeeListJson.toString());
            file.flush();
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }



    }
}