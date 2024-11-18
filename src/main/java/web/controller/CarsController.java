package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String index(@RequestParam(name = "count", required = false) String count, Model model) {
        int value = (count != null) ? Integer.parseInt(count) : Integer.MAX_VALUE;
        model.addAttribute("automobils", carService.carList(value));
        return "cars";
    }
}
