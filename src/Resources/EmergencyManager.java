package Resources;

public class EmergencyManager {

    public void startSystemInteractive() {
        EmergencyDetector detector = new EmergencyDetector(5);
        EmergencyEvent event = detector.detectEventInteractive();

        if (event != null) {
            AlertSender sender = new AlertSender();
            sender.sendAlert(event);
        } else {
            System.out.println("No se activó ninguna emergencia.");
        }
    }
}