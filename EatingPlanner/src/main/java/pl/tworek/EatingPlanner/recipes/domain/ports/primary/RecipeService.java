package pl.tworek.EatingPlanner.recipes.domain.ports.primary;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;

public interface RecipeService {

    Recipe save(Recipe recipe);
}
