package pl.dan.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dan.demo.model.Ingredient;
import pl.dan.demo.model.Taco;
import pl.dan.demo.model.Type;
import pl.dan.demo.service.TacoService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class TacoController {
    @Autowired
    TacoService tacoService;

    @GetMapping("/design")
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = tacoService.createTacos();

        Type[] types = Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping("/design")
    public String processDesign(@Valid @ModelAttribute Taco design, Errors errors) {

        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
