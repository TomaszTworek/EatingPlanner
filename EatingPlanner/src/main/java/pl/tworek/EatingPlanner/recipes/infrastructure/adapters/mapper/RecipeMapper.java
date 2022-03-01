package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.mapper;

import org.mapstruct.Mapper;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

@Mapper
public interface RecipeMapper {

    RecipeEntity recipeToRecipeEntity(Recipe recipe);
    Recipe recipeEntityToRecipe(RecipeEntity recipe);

}
