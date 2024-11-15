package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.models.Car;
import web.service.ReadCars;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final ReadCars readCars;

    public CarsController(ReadCars readCars) {
        this.readCars = readCars;
    }

    List<Car> cars = new ArrayList<>();

    @GetMapping()
    public String index(HttpServletRequest request, Model model) {
        String count = request.getParameter("count");
        if (count != null) {
            cars = readCars.carList(Integer.parseInt(count));
            model.addAttribute("automobils", cars);

        } else {
            cars = readCars.carList(Integer.MAX_VALUE);
            model.addAttribute("automobils", cars);
        }
        return "cars";
    }
}
