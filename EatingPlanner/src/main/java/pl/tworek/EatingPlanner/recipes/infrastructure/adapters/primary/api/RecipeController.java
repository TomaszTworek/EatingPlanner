package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.primary.RecipePort;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.mapper.RecipeMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.mapper.RecipeResponseMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeRequest;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response.RecipeResponse;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipePort recipePort;

    private final RecipeMapper recipeMapper;

    private final RecipeResponseMapper recipeResponseMapper;

    @PostMapping
    public RecipeResponse save(@RequestBody RecipeRequest recipeRequest) {
        final Recipe recipe = recipeMapper.map(recipeRequest);
        final Recipe savedRecipe = recipePort.add(recipe);
        return recipeResponseMapper.map(savedRecipe);
    }

    @GetMapping("/all")
    public List<RecipeResponse> getAll() {
        final List<Recipe> recipes = recipePort.getAll();
        return recipeResponseMapper.map(recipes);
    }
}
