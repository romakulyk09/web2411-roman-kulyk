public class RentalController {
    CarRepository repository;

    public RentalController(CarRepository repository) {
        this.repository = repository;
    }

    public void bookCar(String clientName, String license, String carModel, int days, String insuranceType) {
        if (days <= 0) {
            System.out.println("Помилка: кількість днів має бути більше 0.");
            return;
        }

        Car car = repository.findByModel(carModel);
        if (car == null) {
            System.out.println("Помилка: авто \"" + carModel + "\" недоступне.");
            return;
        }

        Client client = new Client(clientName, license);
        Rental rental = new Rental(car, client, days, insuranceType);
        rental.printReceipt();
    }
}
