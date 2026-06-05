public class Rental {
    Car car;
    Client client;
    int days;
    Insurance insurance;

    public Rental(Car car, Client client, int days, String insuranceType) {
        this.car = car;
        this.client = client;
        this.days = days;
        this.insurance = new Insurance(insuranceType, days);
    }

    public double calculateTotalCost() {
        return car.getDailyRate() * days + insurance.getTotalCost();
    }

    public void printReceipt() {
        System.out.println("Чек оренди");
        System.out.println("Клієнт: " + client.name + " (" + client.licenseNumber + ")");
        System.out.println("Машина: " + car.model + " (" + car.carClass + ")");
        System.out.println("Днів: " + days + " x $" + car.getDailyRate() + " = $" + car.getDailyRate() * days);
        System.out.println("Страховка: " + insurance.type + " = $" + insurance.getTotalCost());
        System.out.println("Разом: $" + calculateTotalCost());
    }
}
