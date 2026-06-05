public class SportsCar extends Car {

    public SportsCar(String model, double basePrice) {
        super(model, basePrice);
    }

    public double getDailyRate() {
        return basePrice * 2.5;
    }

    public String getType() {
        return "Спорткар";
    }
}
