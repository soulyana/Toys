package me.soulyana.demo.Controllers;

import me.soulyana.demo.models.Toy;
import me.soulyana.demo.repositories.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    ToyRepository toyRepository;

    @RequestMapping("/")
    public String listToys() {
        return "homepage";
    }

    @RequestMapping("/list")
    public String listToys(Model model) {
        model.addAttribute("toys", toyRepository.findAll());
        return "list";
    }

    @RequestMapping("/addtoy")
    public String addToy(Model model) {
        model.addAttribute("toy", new Toy());
        return "toyform";
    }

    @RequestMapping("/addmethod")
    public String saveToy(@ModelAttribute("toy") Toy toy, BindingResult bindingResult) {
        System.out.println(bindingResult);
        toyRepository.save(toy);
        return "redirect:/";
    }
}
