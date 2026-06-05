public class Sedan extends Car {

    public Sedan(String model, double basePrice) {
        super(model, basePrice);
    }

    public double getDailyRate() {
        return basePrice * 1.0;
    }

    public String getType() {
        return "Седан";
    }
}
