package pl.tworek.EatingPlanner.recipes.domain.ports.secondary;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;

public interface RecipeRepository {

    Recipe save(Recipe recipe);
}
