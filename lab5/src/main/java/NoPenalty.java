public class NoPenalty implements PenaltyStrategy {

    public double calculatePenalty(double dailyRate) {
        return 0;
    }

    public String getDescription() {
        return "Без штрафу";
    }
}
