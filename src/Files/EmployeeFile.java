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
            try {
                reader = new BufferedReader(new FileReader("JSONFiles\\Manager.json"));
                managerListAux = gson.fromJson(reader, (new TypeToken<List<Manager>>() {
                }.getType()));
                managerListAux.add(manager);
                exit = new BufferedWriter(new FileWriter("JSONFiles\\Manager.json"));
                String json = gson.toJson(managerListAux, managerListAux.getClass());
                exit.write(json);
                System.out.println("Manager saved");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println(managerListAux.toString());
                assert exit != null;
                try {
                    exit.close();
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (employeeToSave instanceof Chef chef) {
               //Write to file
            try {
                reader = new BufferedReader(new FileReader("JSONFiles\\Chef.json"));
                chefListAux = gson.fromJson(reader, (new TypeToken<List<Chef>>() {
                }.getType()));
                chefListAux.add(chef);
                exit = new BufferedWriter(new FileWriter("JSONFiles\\Chef.json"));
                String json = gson.toJson(chefListAux, chefListAux.getClass());
                exit.write(json);
                System.out.println("Chef saved");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println(chefListAux.toString());
                assert exit != null;
                try {
                    exit.close();
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        } else if (employeeToSave instanceof Kitchener Kitchener) {
            //Write to file
            try {
                reader = new BufferedReader(new FileReader("JSONFiles\\Kitchener.json"));
                kitchenerListAux = gson.fromJson(reader, (new TypeToken<List<Kitchener>>() {
                }.getType()));
                kitchenerListAux.add(Kitchener);
                exit = new BufferedWriter(new FileWriter("JSONFiles\\Kitchener.json"));
                String json = gson.toJson(kitchenerListAux, kitchenerListAux.getClass());
                exit.write(json);
                System.out.println("Kitchener saved");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println(kitchenerListAux.toString());
                assert exit != null;
                try {
                    exit.close();
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (employeeToSave instanceof Server server) {
            //Save server with gson
            try {
                reader = new BufferedReader(new FileReader("JSONFiles\\Servers.json"));
                serverListAux = gson.fromJson(reader, (new TypeToken<List<Server>>() {
                }.getType()));
                serverListAux.add(server);
                exit = new BufferedWriter(new FileWriter("JSONFiles\\Servers.json"));
                String json = gson.toJson(serverListAux, serverListAux.getClass());
                exit.write(json);
                System.out.println("Server saved");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println(serverListAux.toString());
                assert exit != null;
                try {
                    exit.close();
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (employeeToSave instanceof  Host host) {
            //Save host with gson
            try {
                reader = new BufferedReader(new FileReader("JSONFiles\\Host.json"));
                hostListAux = gson.fromJson(reader, (new TypeToken<List<Host>>() {
                }.getType()));
                hostListAux.add(host);
                exit = new BufferedWriter(new FileWriter("JSONFiles\\Host.json"));
                String json = gson.toJson(hostListAux, hostListAux.getClass());
                exit.write(json);
                System.out.println("Host saved");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println(hostListAux.toString());
                assert exit != null;
                try {
                    exit.close();
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
