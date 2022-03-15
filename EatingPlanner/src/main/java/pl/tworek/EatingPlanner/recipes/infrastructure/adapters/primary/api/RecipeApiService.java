package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.primary.RecipeService;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.mapper.RecipeMapper;

public class RecipeApiService {

    private final RecipeService recipeService;

    private final RecipeMapper recipeMapper;

    public RecipeApiService(RecipeService recipeService, RecipeMapper recipeMapper) {
        this.recipeService = recipeService;
        this.recipeMapper = recipeMapper;
    }

    public RecipeResponse save(RecipeRequest recipeRequest) {
        Recipe recipeToSave = recipeMapper.recipeRequestToRecipe(recipeRequest);
        Recipe savedRecipe = recipeService.save(recipeToSave);
        return recipeMapper.recipeToRecipeResponse(savedRecipe);
    }
}
