package pl.tworek.EatingPlanner.recipes.domain.ports.primary;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;

import java.util.List;

public class DomainRecipeService implements RecipeService {

    private final RecipeRepository recipeRepository;

    public DomainRecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.getAll();
    }
}
