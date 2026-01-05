package App.Main;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class NotificationService {

    public static void send(Notification notification) {
        String output = "\n🔔 RECORDATORIO 🔔\n" +
                notification.getMessage() +
                "\nHora: " + LocalDateTime.now() +
                "\n----------------------";

        // Mostrar en consola
        System.out.println(output);

        // Guardar en archivo
        try (FileWriter writer = new FileWriter("SRC/Resources/notifications.txt", true)) {
            writer.write(output + "\n");
        } catch (IOException e) {
            System.out.println("Error guardando notificación");
        }
    }
}