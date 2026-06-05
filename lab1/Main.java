public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("John Smith", "DL-4821");
        Car car1 = new Car("Toyota Camry", "STANDARD", 40.0);
        Rental rental1 = new Rental(car1, client1, 5, "FULL");
        rental1.printReceipt();

        System.out.println();

        Client client2 = new Client("Anna Brown", "DL-7734");
        Car car2 = new Car("Renault Logan", "ECONOMY", 25.0);
        Rental rental2 = new Rental(car2, client2, 3, "NONE");
        rental2.printReceipt();
    }
}
