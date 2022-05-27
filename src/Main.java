import Jframes.UserInterface;

public class Main {
    public static void main(String[] args) {
System.out.println("Joaquin branch");
        AppResto appResto = new AppResto();
        appResto.setRestoName("La loquita");
        UserInterface appWindow = new UserInterface();
        appWindow.setTitle(appResto.getRestoName());
        appWindow.setVisible(true);

    }
}
