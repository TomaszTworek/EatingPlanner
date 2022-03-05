package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.RecipeRequest;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.RecipeResponse;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

@Mapper
public interface RecipeMapper {

    @Mapping(target = "name", source = "name.value")
    @Mapping(target = "description", source = "description.content")
    @Mapping(target = "toughness", ignore = true)
    @Mapping(target = "defaultServings", ignore = true)
    @Mapping(target = "healthiness", ignore = true)
    @Mapping(target = "tastiness", ignore = true)
    @Mapping(target = "id", ignore = true)
    RecipeEntity recipeToRecipeEntity(Recipe recipe);

    @Mapping(target = "name.value", source = "name")
    @Mapping(target = "description.content", source = "description")
    @Mapping(target = "toughness", ignore = true)
    @Mapping(target = "healthiness", ignore = true)
    @Mapping(target = "tastiness", ignore = true)
    @Mapping(target = "id", ignore = true)
    Recipe recipeEntityToRecipe(RecipeEntity recipe);

    @Mapping(target = "name.value", source = "name")
    @Mapping(target = "description.content", source = "description")
    Recipe recipeRequestToRecipe(RecipeRequest recipeRequest);

    @Mapping(target = "name", source = "name.value")
    RecipeResponse recipeToRecipeResponse(Recipe savedRecipe);

}
