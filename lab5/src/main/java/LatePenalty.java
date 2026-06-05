public class LatePenalty implements PenaltyStrategy {

    int extraDays;

    public LatePenalty(int extraDays) {
        this.extraDays = extraDays;
    }

    public double calculatePenalty(double dailyRate) {
        return dailyRate * extraDays * 1.5;
    }

    public String getDescription() {
        return "Прострочення на " + extraDays + " дн.";
    }
}
