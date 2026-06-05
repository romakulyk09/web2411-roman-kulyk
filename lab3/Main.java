public class Main {
    public static void main(String[] args) {
        CarRepository repo = new CarRepository();
        repo.addCar(new Sedan("Toyota Camry", 40.0));
        repo.addCar(new SportsCar("Ferrari 488", 200.0));
        repo.addCar(new Truck("Volvo FH", 80.0));

        RentalLogger logger = new RentalLogger();
        RentalController controller = new RentalController(repo, logger);

        System.out.println("--- Седан, без штрафу ---");
        controller.bookCar("Іван Петренко", "DL-4821", "Toyota Camry", 5, "FULL", new NoPenalty());

        System.out.println();
        System.out.println("--- Спорткар, штраф за прострочення ---");
        controller.bookCar("Олег Бойко", "DL-7734", "Ferrari 488", 3, "BASIC", new LatePenalty(2));

        System.out.println();
        System.out.println("--- Вантажівка, штраф за пошкодження ---");
        controller.bookCar("Тарас Шевченко", "DL-9900", "Volvo FH", 4, "NONE", new DamagePenalty());

        System.out.println();
        System.out.println("--- Помилка: невірна кількість днів ---");
        controller.bookCar("Анна Коваль", "DL-1111", "Toyota Camry", 0, "BASIC", new NoPenalty());
    }
}
