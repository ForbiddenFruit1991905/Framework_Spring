package ru.example.task2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomController {
//    @GetMapping("/random")
//    public String getRandomNumber(Model model) {
//        Random random = new Random();
//        model.addAttribute("number", random.nextInt(100) + 1);
//        return "randomNumber";
//    }

//    @GetMapping("/random/{min}/{max}")
//    public String getRandomNumber(@PathVariable("min") int min, @PathVariable("max") int max, Model model) {
//        Random random = new Random();
//        model.addAttribute("min", min);
//        model.addAttribute("max", max);
//        model.addAttribute("number", random.nextInt(min, max +1));
//        return "randomNumber";
//    }

    @GetMapping("/random")
    public String getRandomNumber(@RequestParam("min") Integer min, @RequestParam("max") Integer max, Model model) {
        Random random = new Random();
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", random.nextInt(min, max +1));
        return "randomNumber";
        // Пример: http://localhost:8080/random?min=25&max=55
    }

    @Value("${data.parameter.min:25}")
    private Integer minDefault;
    @Value("${data.parameter.max:55}")
    private Integer maxDefault;

    @GetMapping("/random/{min}/{max}")
    public String getRandomNumber(@PathVariable("min") int min, @PathVariable("max") int max, Model model) {
        Random random = new Random();
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("min_default", minDefault);
        model.addAttribute("max_default", maxDefault);
        model.addAttribute("number", random.nextInt(min, max +1));
        return "randomNumber";
    }
}
