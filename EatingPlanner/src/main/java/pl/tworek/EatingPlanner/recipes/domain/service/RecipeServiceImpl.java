package pl.tworek.EatingPlanner.recipes.domain.service;

import lombok.RequiredArgsConstructor;
import pl.tworek.EatingPlanner.recipes.domain.exceptions.InvalidRecipeName;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;
import pl.tworek.EatingPlanner.recipes.domain.vo.RecipeName;

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
        final RecipeName name = recipe.getName();
        if (recipeWithNameExists(name)) {
            throw new InvalidRecipeName(name);
        }
        return recipeRepository.save(recipe);
    }

    private boolean recipeWithNameExists(RecipeName name) {
        return recipeRepository.existsByName(name);
    }
}
