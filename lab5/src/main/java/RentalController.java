public class RentalController {
    CarRepository repository;
    RentalLogger logger;

    public RentalController(CarRepository repository, RentalLogger logger) {
        this.repository = repository;
        this.logger = logger;
    }

    public void bookCar(String clientName, String license, String carModel, int days, String insuranceType, PenaltyStrategy penalty) {
        if (days <= 0) {
            logger.logError("кількість днів має бути більше 0");
            return;
        }

        Car car = repository.findByModel(carModel);
        if (car == null) {
            logger.logError("авто \"" + carModel + "\" недоступне");
            return;
        }

        logger.logBooking(clientName, carModel);
        Client client = new Client(clientName, license);
        Rental rental = new Rental(car, client, days, insuranceType, penalty);
        rental.printReceipt();
    }
}
