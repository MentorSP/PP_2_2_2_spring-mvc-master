package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final CarService carService = new CarService();
    private final List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("Lada 2110", 111, "white"));
        carList.add(new Car("Lada 2111", 222, "red"));
        carList.add(new Car("Lada 2112", 333, "blue"));
        carList.add(new Car("Lada 2114", 444, "grey"));
        carList.add(new Car("Lada 2115", 555, "black"));
    }

    @GetMapping("/cars")
    public String getCarList(@RequestParam(defaultValue = "5") int count, ModelMap model) {
        model.addAttribute("carList", carService.getCarList(carList, count));
        return "cars";
    }
}
