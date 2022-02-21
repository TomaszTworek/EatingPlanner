package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.recipedb.mysql;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.RecipeRepository;

public class MySQLRecipeRepositoryImpl implements RecipeRepository {

    private MySQLRecipeRepository mySQLRecipeRepository;

    @Override
    public void save(Recipe recipe) {
        //mapped here
    }
}
