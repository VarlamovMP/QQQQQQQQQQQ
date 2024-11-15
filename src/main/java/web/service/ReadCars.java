package web.service;

import org.springframework.stereotype.Component;
import web.controller.CarsController;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReadCars {
    private List<Car> automobils;

    {
        automobils = new ArrayList<>();
        automobils.add(new Car("Toyota", "Japan", 1937));
        automobils.add(new Car("BMW", "Germany", 1916));
        automobils.add(new Car("Mazda", "Japan", 1920));
        automobils.add(new Car("Mersedes", "Germany", 1902));
        automobils.add(new Car("OKA", "USSR", 1987));
    }

    private List<Car> automobils() {
        return this.automobils = automobils;
    }

    public List<Car> carList(int x) {
        List<Car> result = new ArrayList<>();
        if (x > 0 && x <= automobils.size()) {
            for (int i = 0; i < x; i++) {
                result.add(automobils.get(i));
            }
        } else if (x > automobils.size()) {
            result = automobils();
        }
        return result;
    }
}
