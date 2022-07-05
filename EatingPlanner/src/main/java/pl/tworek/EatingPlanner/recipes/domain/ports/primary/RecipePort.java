package pl.tworek.EatingPlanner.recipes.domain.ports.primary;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.vo.RecipeName;

import java.util.List;

public interface RecipePort {

    Recipe add(Recipe recipe);

    List<Recipe> getAll();

    Boolean exists(RecipeName name);
}
