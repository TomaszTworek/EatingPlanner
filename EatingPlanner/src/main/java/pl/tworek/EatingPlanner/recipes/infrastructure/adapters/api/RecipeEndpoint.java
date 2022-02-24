package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.api;

import org.springframework.web.bind.annotation.RestController;
import pl.tworek.EatingPlanner.recipes.domain.ports.RecipeService;

@RestController
public class RecipeEndpoint {

    private RecipeService recipeService;

}