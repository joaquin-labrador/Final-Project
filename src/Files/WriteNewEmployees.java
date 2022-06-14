package Files;

import Employee.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            assert exit != null;
            try {
                exit.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void changePassword(Object T) {
        Scanner scanner = new Scanner(System.in);
        String newPassword = null;
        do {
            if(newPassword != null) {
                System.out.println("Contraseña no segura, intente de nuevo");
            }
            System.out.println("Enter your new password: ");
            newPassword = scanner.nextLine();
            savedNewPassword(newPassword, T);
        }while(newPassword.length() < 6 );


    }


    private static void savedNewPassword(String newPassword, Object o) {
        ;
        if (o instanceof Manager) {
            Manager manager = (Manager) o;
            managerSavedNewPassword(manager, newPassword);
        } else if (o instanceof Chef) {
            Chef chef = (Chef) o;
            chefSavedNewPassword(chef, newPassword);
        } else if (o instanceof Kitchener) {
            Kitchener kitchener = (Kitchener) o;
            kitchenerSavedNewPassword(kitchener, newPassword);
        } else if (o instanceof Server) {
            Server server = (Server) o;
            serverSavedNewPassword(server, newPassword);
        } else if (o instanceof Host) {
            Host host = (Host) o;
            hostSavedNewPassword(host, newPassword);
        }
    }

    private static void managerSavedNewPassword(Manager manager, String password) {
        BufferedWriter exit = null;
        BufferedReader reader = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Manager.json"));
            List<Manager> managerListAux = gson.fromJson(reader, (new TypeToken<List<Manager>>() {
            }.getType()));
            for (Manager managerAux : managerListAux) {
                if (managerAux.equals(manager)) {

                    managerAux.setPassword(password);
                    System.out.println("Password changed");

                }
            }
            exit = new BufferedWriter(new FileWriter("JSONFiles\\Manager.json"));
            String json = gson.toJson(managerListAux, managerListAux.getClass());
            exit.write(json);
            System.out.println("Password changed");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Password not changed");
        } finally {
            assert exit != null;
            try {
                exit.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private static void chefSavedNewPassword(Chef chef, String password) {
        BufferedWriter exit = null;
        BufferedReader reader = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Chef.json"));
            List<Chef> chefListAux = gson.fromJson(reader, (new TypeToken<List<Chef>>() {
            }.getType()));
            for (Chef chefAux : chefListAux) {
                if (chefAux.equals(chef)) {
                    chefAux.setPassword(password);
                }
            }
            exit = new BufferedWriter(new FileWriter("JSONFiles\\Chef.json"));
            String json = gson.toJson(chefListAux, chefListAux.getClass());
            exit.write(json);
            System.out.println("Password changed");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Password not changed");
        } finally {
            assert exit != null;
            try {
                exit.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void kitchenerSavedNewPassword(Kitchener kitchener, String password) {
        BufferedWriter exit = null;
        BufferedReader reader = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Kitchener.json"));
            List<Kitchener> kitchenerListAux = gson.fromJson(reader, (new TypeToken<List<Kitchener>>() {
            }.getType()));
            for (Kitchener kitchenerAux : kitchenerListAux) {
                if (kitchenerAux.equals(kitchener)) {
                    kitchenerAux.setPassword(password);
                }
            }
            exit = new BufferedWriter(new FileWriter("JSONFiles\\Kitchener.json"));
            String json = gson.toJson(kitchenerListAux, kitchenerListAux.getClass());
            exit.write(json);
            System.out.println("Password changed");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Password not changed");
        } finally {
            assert exit != null;
            try {
                exit.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void serverSavedNewPassword(Server server, String password) {
        BufferedWriter exit = null;
        BufferedReader reader = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Servers.json"));
            List<Server> serverListAux = gson.fromJson(reader, (new TypeToken<List<Server>>() {
            }.getType()));
            for (Server serverAux : serverListAux) {
                if (serverAux.equals(server)) {
                    serverAux.setPassword(password);
                }
            }

            exit = new BufferedWriter(new FileWriter("JSONFiles\\Servers.json"));
            String json = gson.toJson(serverListAux, serverListAux.getClass());
            exit.write(json);
            System.out.println("Password changed");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Password not changed");
        } finally {
            assert exit != null;
            try {
                exit.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void hostSavedNewPassword(Host host, String password) {
        BufferedWriter exit = null;
        BufferedReader reader = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            reader = new BufferedReader(new FileReader("JSONFiles\\Host.json"));
            List<Host> hostListAux = gson.fromJson(reader, (new TypeToken<List<Host>>() {
            }.getType()));
            for (Host hostAux : hostListAux) {
                if (hostAux.equals(host)) {
                    hostAux.setPassword(password);
                }
            }
            exit = new BufferedWriter(new FileWriter("JSONFiles\\Host.json"));
            String json = gson.toJson(hostListAux, hostListAux.getClass());
            exit.write(json);
            System.out.println("Password changed");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Password not changed");
        } finally {
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
