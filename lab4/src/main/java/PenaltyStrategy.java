public interface PenaltyStrategy {
    double calculatePenalty(double dailyRate);
    String getDescription();
}
