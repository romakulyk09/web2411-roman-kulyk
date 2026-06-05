public class Main {
    public static void main(String[] args) {
        CarRepository repo = new CarRepository();
        repo.addCar(new Car("Toyota Camry", "STANDARD", 40.0));
        repo.addCar(new Car("Renault Logan", "ECONOMY", 25.0));

        RentalController controller = new RentalController(repo);

        System.out.println("--- Успішне бронювання ---");
        controller.bookCar("John Smith", "DL-4821", "Toyota Camry", 5, "FULL");

        System.out.println();
        System.out.println("--- Помилка: невірна кількість днів ---");
        controller.bookCar("Anna Brown", "DL-7734", "Renault Logan", -1, "BASIC");

        System.out.println();
        System.out.println("--- Помилка: авто недоступне ---");
        controller.bookCar("Tom Black", "DL-9900", "BMW X5", 3, "NONE");
    }
}
