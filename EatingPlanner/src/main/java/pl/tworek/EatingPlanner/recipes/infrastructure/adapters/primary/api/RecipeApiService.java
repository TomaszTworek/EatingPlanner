package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api;

import org.springframework.core.io.Resource;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.primary.RecipeService;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.mapper.RecipeMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeRequest;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response.RecipeResponse;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.ImageStorageService;

import java.util.List;

public class RecipeApiService {

    private final RecipeService recipeService;

    private final RecipeMapper recipeMapper;

    private final ImageStorageService imageStorageService;

    public RecipeApiService(RecipeService recipeService, RecipeMapper recipeMapper, ImageStorageService imageStorageService) {
        this.recipeService = recipeService;
        this.recipeMapper = recipeMapper;
        this.imageStorageService = imageStorageService;
    }

    public RecipeResponse save(RecipeRequest recipeRequest) {
        Recipe recipeToSave = recipeMapper.recipeRequestToRecipe(recipeRequest);
        Recipe savedRecipe = recipeService.save(recipeToSave);
        return recipeMapper.recipeToRecipeResponse(savedRecipe);
    }

    public List<RecipeResponse> getAll() {
        List<Recipe> allRecipes = recipeService.getAll();
        return recipeMapper.recipesToRecipeResponses(allRecipes);
    }
}
