package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api;

import org.springframework.web.bind.annotation.*;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeRequest;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response.RecipeResponse;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeApiService recipeApiService;

    public RecipeController(RecipeApiService recipeApiService) {
        this.recipeApiService = recipeApiService;
    }

    @PostMapping
    public RecipeResponse saveRecipe(@RequestBody RecipeRequest recipeRequest) {
        return recipeApiService.save(recipeRequest);
    }

    @GetMapping("/all")
    public List<RecipeResponse> getAllRecipes(){
        return recipeApiService.getAll();
    }

    @GetMapping("/test")
    public String test() {
        return "TEST";
    }
}