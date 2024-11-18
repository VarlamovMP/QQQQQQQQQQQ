package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> automobils;

    {
        automobils = new ArrayList<>();
        automobils.add(new Car("Toyota", "Japan", 1937));
        automobils.add(new Car("BMW", "Germany", 1916));
        automobils.add(new Car("Mazda", "Japan", 1920));
        automobils.add(new Car("Mersedes", "Germany", 1902));
        automobils.add(new Car("OKA", "USSR", 1987));
    }

    @Override
    public List<Car> carList(int count) {
        List<Car> result = new ArrayList<>();
        if (count > 0 && count <= automobils.size()) {
            for (int i = 0; i < count; i++) {
                result.add(automobils.get(i));
            }
        } else if (count > automobils.size()) {
            result = automobils;
        }
        return result;
    }
}
