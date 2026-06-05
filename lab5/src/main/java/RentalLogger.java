// Pure Fabrication: не частина предметної області, але потрібен для логування
public class RentalLogger {

    public void logBooking(String clientName, String carModel) {
        System.out.println("[Лог] Бронювання: " + clientName + " -> " + carModel);
    }

    public void logError(String message) {
        System.out.println("[Лог] Помилка: " + message);
    }

    public void logCancelled(String clientName) {
        System.out.println("[Лог] Скасовано бронювання для: " + clientName);
    }
}
