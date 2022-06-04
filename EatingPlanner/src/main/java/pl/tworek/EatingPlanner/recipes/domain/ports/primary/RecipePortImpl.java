package pl.tworek.EatingPlanner.recipes.domain.ports.primary;

import lombok.RequiredArgsConstructor;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.service.RecipeService;

import java.util.List;

@RequiredArgsConstructor
public class RecipePortImpl implements RecipePort {

    private final RecipeService recipeService;

    @Override
    public Recipe add(Recipe recipe) {
        return recipeService.add(recipe);
    }

    @Override
    public List<Recipe> getAll() {
        return recipeService.getAll();
    }
}