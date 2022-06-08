package Files;


import Employee.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeFile implements FilesOperations {
    List<Employee> employeeList = new ArrayList<>();

    WriteNewEmployees writeNewEmployees = new WriteNewEmployees();

    DeleteEmployee deleteEmployee = new DeleteEmployee();

    public EmployeeFile() throws IOException {
        readFile();
    }

    @Override
    public void readFile() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Manager> managerListAux = new ArrayList<>();
        List<Chef> chefListAux = new ArrayList<>();
        List<Kitchener> kitchenerListAux = new ArrayList<>();
        List<Server> serverListAux = new ArrayList<>();
        List<Host> hostListAux = new ArrayList<>();
        BufferedReader readerManager = null;
        BufferedReader readerChef = null;
        BufferedReader readerKitchener = null;
        BufferedReader readerServer = null;
        BufferedReader readerHost = null;
        try {
            //region Read File
            readerManager = new BufferedReader(new FileReader("JSONFiles\\Manager.json"));
            readerChef = new BufferedReader(new FileReader("JSONFiles\\Chef.json"));
            readerKitchener = new BufferedReader(new FileReader("JSONFiles\\Kitchener.json"));
            readerServer = new BufferedReader(new FileReader("JSONFiles\\Servers.json"));
            readerHost = new BufferedReader(new FileReader("JSONFiles\\Host.json"));
            managerListAux = gson.fromJson(readerManager,
                    (new TypeToken<List<Manager>>() {
                    }.getType()));
            chefListAux = gson.fromJson(readerChef,
                    (new TypeToken<List<Chef>>() {
                    }.getType()));
            kitchenerListAux = gson.fromJson(readerKitchener,
                    (new TypeToken<List<Kitchener>>() {
                    }.getType()));
            serverListAux = gson.fromJson(readerServer,
                    (new TypeToken<List<Server>>() {
                    }.getType()));
            hostListAux = gson.fromJson(readerHost,
                    (new TypeToken<List<Host>>() {
                    }.getType()));

            this.employeeList.addAll(managerListAux);
            this.employeeList.addAll(chefListAux);
            this.employeeList.addAll(kitchenerListAux);
            this.employeeList.addAll(serverListAux);
            this.employeeList.addAll(hostListAux);
            //endregion
        } catch (IOException e) {
            System.out.println("File read Error\n");
            e.printStackTrace();
        } finally {
            //region Close Files
            assert readerManager != null;
            readerManager.close();
            assert readerKitchener != null;
            readerKitchener.close();
            readerChef.close();
            assert readerServer != null;
            readerServer.close();
            assert readerHost != null;
            readerHost.close();
            //endregion
        }
    }


    public void writeFile(Employee employeeToSave) {
        BufferedReader reader;
        BufferedWriter exit;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        exit = null;
        reader = null;
        List<Manager> managerListAux = new ArrayList<>();
        List<Chef> chefListAux = new ArrayList<>();
        List<Kitchener> kitchenerListAux = new ArrayList<>();
        List<Server> serverListAux = new ArrayList<>();
        List<Host> hostListAux = new ArrayList<>();

        if (employeeToSave instanceof Manager manager) {
            //Write to file
            writeNewEmployees.addManager(reader, exit, gson, manager, managerListAux);

        } else if (employeeToSave instanceof Chef chef) {
            //Write to file
            writeNewEmployees.addChef(reader, exit, gson, chef, chefListAux);


        } else if (employeeToSave instanceof Kitchener Kitchener) {
            //Write to file
            writeNewEmployees.addKitchener(reader, exit, gson, Kitchener, kitchenerListAux);

        } else if (employeeToSave instanceof Server server) {
            //Save server with gson
            writeNewEmployees.addServer(reader, exit, gson, server, serverListAux);

        } else if (employeeToSave instanceof Host host) {
            //Save host with gson
            writeNewEmployees.addHost(reader, exit, gson, host, hostListAux);

        }
    }

    public void deleteEmployee(Employee employeeToDelete) {
        BufferedReader reader;
        BufferedWriter exit;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        exit = null;
        reader = null;
        List<Manager> managerListAux = new ArrayList<>();
        List<Chef> chefListAux = new ArrayList<>();
        List<Kitchener> kitchenerListAux = new ArrayList<>();
        List<Server> serverListAux = new ArrayList<>();
        List<Host> hostListAux = new ArrayList<>();
        if (employeeToDelete instanceof Manager manager) {
            deleteEmployee.deleteManager(reader, exit, gson, manager, managerListAux);
        }
        else if (employeeToDelete instanceof Chef chef) {
            deleteEmployee.deleteChef(reader, exit, gson, chef, chefListAux);
        }
        else if (employeeToDelete instanceof Kitchener Kitchener) {
            deleteEmployee.deleteKitchener(reader, exit, gson, Kitchener, kitchenerListAux);
        }
        else if (employeeToDelete instanceof Server server) {
            deleteEmployee.deleteServer(reader, exit, gson, server, serverListAux);
        }
        else if (employeeToDelete instanceof Host host) {
            deleteEmployee.deleteHost(reader, exit, gson, host, hostListAux);
        }


    }

    @Override
    public void showFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Manager.json"));
            reader.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
