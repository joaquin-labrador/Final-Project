package Files;

import Employee.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteNewEmployees {

    public WriteNewEmployees() {
    }

    public void addManager(BufferedReader reader, BufferedWriter exit, Gson gson, Manager manager, List<Manager> managerListAux) {
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Manager.json"));
            managerListAux = gson.fromJson(reader, (new TypeToken<List<Manager>>() {
            }.getType()));
            if (managerListAux == null) {
                managerListAux = new ArrayList<>();
            }
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
    }

    public void addChef(BufferedReader reader, BufferedWriter exit, Gson gson, Chef chef, List<Chef> chefListAux) {
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Chef.json"));
            chefListAux = gson.fromJson(reader, (new TypeToken<List<Chef>>() {
            }.getType()));

            if (chefListAux == null) {
                chefListAux = new ArrayList<>();
            }
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
    }

    public void addKitchener(BufferedReader reader, BufferedWriter exit, Gson gson, Kitchener kitchener, List<Kitchener> kitchenerListAux) {
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Kitchener.json"));
            kitchenerListAux = gson.fromJson(reader, (new TypeToken<List<Kitchener>>() {
            }.getType()));

            if (kitchenerListAux == null) {
                kitchenerListAux = new ArrayList<Kitchener>();
            }
            kitchenerListAux.add(kitchener);
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
    }

    public void addServer(BufferedReader reader, BufferedWriter exit, Gson gson, Server server, List<Server> serverListAux) {
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Servers.json"));
            serverListAux = gson.fromJson(reader, (new TypeToken<List<Server>>() {
            }.getType()));
            if (serverListAux == null) {
                serverListAux.add(server);
            }
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
    }

    public void addHost(BufferedReader reader, BufferedWriter exit, Gson gson, Host host, List<Host> hostListAux) {
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Host.json"));
            hostListAux = gson.fromJson(reader, (new TypeToken<List<Host>>() {
            }.getType()));
            if (hostListAux == null) {
                hostListAux = new ArrayList<>();
            }
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
