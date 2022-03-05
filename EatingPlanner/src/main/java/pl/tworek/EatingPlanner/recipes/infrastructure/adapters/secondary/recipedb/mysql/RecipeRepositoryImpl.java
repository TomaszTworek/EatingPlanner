package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.mapper.RecipeMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

public class RecipeRepositoryImpl implements RecipeRepository {

    private final MySQLRecipeRepository mySQLRecipeRepository;

    private final RecipeMapper mapper;

    public RecipeRepositoryImpl(MySQLRecipeRepository mySQLRecipeRepository, RecipeMapper mapper) {
        this.mySQLRecipeRepository = mySQLRecipeRepository;
        this.mapper = mapper;
    }

    @Override
    public Recipe save(Recipe recipe) {
        RecipeEntity recipeEntity = mapper.recipeToRecipeEntity(recipe);
        RecipeEntity savedEntity = mySQLRecipeRepository.save(recipeEntity);
        return mapper.recipeEntityToRecipe(savedEntity);
    }
}