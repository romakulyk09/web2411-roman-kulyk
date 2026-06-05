public class DamagePenalty implements PenaltyStrategy {

    public double calculatePenalty(double dailyRate) {
        return dailyRate * 3;
    }

    public String getDescription() {
        return "Пошкодження авто";
    }
}
