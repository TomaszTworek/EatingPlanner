package pl.tworek.EatingPlanner.recipes.domain.ports.secondary;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;

import java.util.List;

public interface RecipeRepository {

    Recipe save(Recipe recipe);

    List<Recipe> getAll();
}
