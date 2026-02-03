package Resources;

import java.util.List;

public class EmergencyManager {

    public void startSystemInteractive() {

        // 🔹 Cargar centros de emergencia desde JSON
        List<EmergencyCenter> centers = JsonDataLoader.loadCenters("SRC/Resources/centers.json");

        System.out.println("======================================");
        System.out.println("   CENTROS DE EMERGENCIA DISPONIBLES");
        System.out.println("======================================");

        if (centers.isEmpty()) {
            System.out.println("⚠ No se han podido cargar centros desde el JSON.");
        } else {
            for (EmergencyCenter c : centers) {
                System.out.println(" - " + c);
            }
        }

        System.out.println("\n======================================");
        System.out.println("   SISTEMA DE DETECCIÓN DE EMERGENCIAS");
        System.out.println("======================================");

        // 🔹 Sistema actual
        EmergencyDetector detector = new EmergencyDetector(5);
        EmergencyEvent event = detector.detectEventInteractive();

        if (event != null) {
            AlertSender sender = new AlertSender();
            sender.sendAlert(event);

            // 🔹 Mostrar servicios útiles tras la emergencia
            if (!centers.isEmpty()) {
                System.out.println("\n=== SERVICIOS DE EMERGENCIA EN LA ZONA ===");
                for (EmergencyCenter c : centers) {
                    System.out.println("✔ " + c.getType() + " -> " + c.getName());
                }
            }

        } else {
            System.out.println("No se activó ninguna emergencia.");
        }
    }
}

