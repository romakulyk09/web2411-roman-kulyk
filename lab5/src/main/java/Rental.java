public class Rental {
    Car car;
    Client client;
    int days;
    Insurance insurance;
    PenaltyStrategy penalty;

    public Rental(Car car, Client client, int days, String insuranceType, PenaltyStrategy penalty) {
        this.car = car;
        this.client = client;
        this.days = days;
        this.insurance = new Insurance(insuranceType, days);
        this.penalty = penalty;
    }

    public double calculateTotalCost() {
        return car.getDailyRate() * days + insurance.getTotalCost() + penalty.calculatePenalty(car.getDailyRate());
    }

    public void printReceipt() {
        System.out.println("Чек оренди");
        System.out.println("Клієнт: " + client.name + " (" + client.licenseNumber + ")");
        System.out.println("Машина: " + car.model + " (" + car.getType() + ")");
        System.out.println("Днів: " + days + " x $" + car.getDailyRate() + " = $" + car.getDailyRate() * days);
        System.out.println("Страховка: " + insurance.type + " = $" + insurance.getTotalCost());
        System.out.println("Штраф: " + penalty.getDescription() + " = $" + penalty.calculatePenalty(car.getDailyRate()));
        System.out.println("Разом: $" + calculateTotalCost());
    }
}
