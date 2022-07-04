package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql;

import lombok.RequiredArgsConstructor;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;
import pl.tworek.EatingPlanner.recipes.domain.vo.RecipeName;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.mapper.RecipeEntityMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

import java.util.List;

@RequiredArgsConstructor
public class RecipeRepositoryImpl implements RecipeRepository {

    private final MySQLRecipeReadRepository mySQLRecipeReadRepository;

    private final RecipeEntityMapper mapper;

    @Override
    public Recipe save(Recipe recipe) {
        RecipeEntity recipeEntity = mapper.map(recipe);
        RecipeEntity savedEntity = mySQLRecipeReadRepository.save(recipeEntity);
        return mapper.map(savedEntity);
    }

    @Override
    public List<Recipe> getAll() {
        List<RecipeEntity> allRecipeEntities = mySQLRecipeReadRepository.findAll();
        return mapper.map(allRecipeEntities);
    }

    @Override
    public boolean existsByName(RecipeName name) {
        return mySQLRecipeReadRepository.existsByName(name.getValue());
    }
}
