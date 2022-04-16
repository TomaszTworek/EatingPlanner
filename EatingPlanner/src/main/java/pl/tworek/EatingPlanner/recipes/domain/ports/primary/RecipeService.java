package pl.tworek.EatingPlanner.recipes.domain.ports.primary;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe save(Recipe recipe);

    List<Recipe> getAll();
}
