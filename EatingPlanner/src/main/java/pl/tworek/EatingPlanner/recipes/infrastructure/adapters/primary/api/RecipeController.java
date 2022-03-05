package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeApiService recipeApiService;

    public RecipeController(RecipeApiService recipeApiService) {
        this.recipeApiService = recipeApiService;
    }

    @PostMapping
    public RecipeResponse saveRecipe(@RequestBody RecipeRequest recipeRequest) {
        System.out.println(recipeRequest);
        return recipeApiService.save(recipeRequest);
    }

    @GetMapping("/test")
    public String test() {
        return "TEST";
    }
}