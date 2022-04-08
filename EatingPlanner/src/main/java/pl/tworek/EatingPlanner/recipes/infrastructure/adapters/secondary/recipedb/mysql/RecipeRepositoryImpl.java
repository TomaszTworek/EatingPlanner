package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql;

import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.mapper.RecipeMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

import java.util.List;

public class RecipeRepositoryImpl implements RecipeRepository {

    private final MySQLRecipeRepository mySQLRecipeRepository;

    private final MySQLRecipePhotoRepository mySQLRecipePhotoRepository;

    private final RecipeMapper mapper;

    public RecipeRepositoryImpl(MySQLRecipeRepository mySQLRecipeRepository, MySQLRecipePhotoRepository mySQLRecipePhotoRepository, RecipeMapper mapper) {
        this.mySQLRecipeRepository = mySQLRecipeRepository;
        this.mySQLRecipePhotoRepository = mySQLRecipePhotoRepository;
        this.mapper = mapper;
    }

    @Override
    public Recipe save(Recipe recipe) {
        RecipeEntity recipeEntity = mapper.recipeToRecipeEntity(recipe);
        RecipeEntity savedEntity = mySQLRecipeRepository.save(recipeEntity);
        return mapper.recipeEntityToRecipe(savedEntity);
    }

    @Override
    public List<Recipe> getAll() {
        List<RecipeEntity> allRecipeEntities = mySQLRecipeRepository.findAll();
        return mapper.recipeEntitiesToRecipes(allRecipeEntities);
    }
}
