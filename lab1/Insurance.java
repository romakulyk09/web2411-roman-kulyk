public class Insurance {
    String type;
    double dailyRate;
    int days;

    public Insurance(String type, int days) {
        this.type = type;
        this.days = days;

        if (type.equals("BASIC")) {
            dailyRate = 10.0;
        } else if (type.equals("FULL")) {
            dailyRate = 25.0;
        } else {
            dailyRate = 0.0;
        }
    }

    public double getTotalCost() {
        return dailyRate * days;
    }
}
