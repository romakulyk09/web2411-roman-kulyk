import java.util.ArrayList;

public class CarRepository {
    ArrayList<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car findByModel(String model) {
        for (Car car : cars) {
            if (car.model.equals(model)) {
                return car;
            }
        }
        return null;
    }
}
