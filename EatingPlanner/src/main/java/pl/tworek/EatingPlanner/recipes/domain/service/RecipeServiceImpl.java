package pl.tworek.EatingPlanner.recipes.domain.service;

import lombok.RequiredArgsConstructor;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;

import java.util.List;

@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.getAll();
    }

    @Override
    public Recipe add(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
