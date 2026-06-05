public abstract class Car {
    String model;
    double basePrice;

    public Car(String model, double basePrice) {
        this.model = model;
        this.basePrice = basePrice;
    }

    public abstract double getDailyRate();

    public abstract String getType();
}
