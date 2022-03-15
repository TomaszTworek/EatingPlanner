package pl.tworek.EatingPlanner.recipes.domain.ports.primary;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;

public class DomainRecipeService implements RecipeService {

    private final RecipeRepository recipeRepository;

    public DomainRecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
