public class Car {
    String model;
    String carClass;
    double basePrice;

    public Car(String model, String carClass, double basePrice) {
        this.model = model;
        this.carClass = carClass;
        this.basePrice = basePrice;
    }

    public double getDailyRate() {
        if (carClass.equals("ECONOMY")) {
            return basePrice * 1.0;
        } else if (carClass.equals("STANDARD")) {
            return basePrice * 1.5;
        } else {
            return basePrice * 2.5;
        }
    }
}
