package App.Main;
import Resources.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/*** Punto de entrada.***/
public class Main {
    public static void main(String[] args) {

        // CARGA Y MUESTRA DEL ARCHIVO JSON
        System.out.println("\n=== CARGANDO DATOS DE CENTROS ===");
        String rutaArchivo = "src/Resources/Centers.json"; // Asegúrate de que la 'R' de Resources coincida con tu carpeta
        List<CentersPOJO> misCentros = JsonDataLoader.loadCenters(rutaArchivo);

        if (misCentros.isEmpty()) {
            System.out.println("⚠ No se han cargado centros. Revisa la ruta o el formato del JSON.");
        } else {
            System.out.println("✅ ¡Éxito! Se han cargado " + misCentros.size() + " centros:");
            for (CentersPOJO centro : misCentros) {
                System.out.println(centro);

        System.out.println("=== SISTEMA DE EMERGENCIAS ===");

        // 1. Iniciar el gestor de emergencias
        EmergencyManager manager = new EmergencyManager();
        // Nota: Si startSystemInteractive() tiene un bucle infinito (while),
        // el código de abajo no se ejecutará hasta que salgas del menú.
        manager.startSystemInteractive(misCentros);

        // 2. Configuración de Recordatorios
        Scanner sc = new Scanner(System.in);
        NotificationScheduler scheduler = new NotificationScheduler();

        System.out.println("\n=== SISTEMA DE RECORDATORIOS ===");
        System.out.print("Mensaje del recordatorio: ");
        String message = sc.nextLine();

        System.out.print("¿En cuántos minutos quieres que se avise?: ");
        int minutes = sc.nextInt();

        LocalDateTime triggerTime = LocalDateTime.now().plusMinutes(minutes);
        Notification notification = new Notification(message, triggerTime);
        scheduler.schedule(notification);

        System.out.println("✔ Recordatorio programado correctamente.");


            }
        }
    }
}
