package Main;
import Resources.EmergencyManager;
import java.util.Scanner;

/*** Punto de entrada.***/
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE EMERGENCIAS ===");
        EmergencyManager manager = new EmergencyManager();
        manager.startSystemInteractive();
    }
}

