package pl.tworek.EatingPlanner.recipes.domain.ports;

import lombok.AllArgsConstructor;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;

@AllArgsConstructor
public class DomainRecipeService implements RecipeService {

    private final RecipeRepository recipeRepository;
    
    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
