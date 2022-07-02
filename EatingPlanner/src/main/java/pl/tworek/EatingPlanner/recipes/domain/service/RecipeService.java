package pl.tworek.EatingPlanner.recipes.domain.service;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();

    Recipe add(Recipe recipe);
}
