package pl.tworek.EatingPlanner.recipes.domain.ports;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;

public interface RecipeRepository {

    void save(Recipe recipe);
}
