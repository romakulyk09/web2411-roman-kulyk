public class Truck extends Car {

    public Truck(String model, double basePrice) {
        super(model, basePrice);
    }

    public double getDailyRate() {
        return basePrice * 1.8;
    }

    public String getType() {
        return "Вантажівка";
    }
}
