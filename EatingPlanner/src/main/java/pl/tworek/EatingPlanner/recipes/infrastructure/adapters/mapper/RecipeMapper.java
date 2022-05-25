package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeRequest;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response.RecipeResponse;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RecipeMapper {

    @Mapping(target = "name", source = "name.value")
    @Mapping(target = "description", source = "description.content")
    @Mapping(target = "preparingTime", source = "preparingTime.time")
    @Mapping(target = "recipePhotoEntity.title", source = "recipePhoto.title")
    @Mapping(target = "recipePhotoEntity.url", source = "recipePhoto.url")
    @Mapping(target = "toughness", ignore = true)
    @Mapping(target = "defaultServings", ignore = true)
    @Mapping(target = "healthiness", ignore = true)
    @Mapping(target = "tastiness", ignore = true)
    @Mapping(target = "id", ignore = true)
    RecipeEntity recipeToRecipeEntity(Recipe recipe);

    @Mapping(target = "name.value", source = "name")
    @Mapping(target = "description.content", source = "description")
    @Mapping(target = "preparingTime.time", source = "preparingTime")
    @Mapping(target = "recipePhoto.title", source = "recipePhotoEntity.title")
    @Mapping(target = "recipePhoto.url", source = "recipePhotoEntity.url")
    @Mapping(target = "toughness", ignore = true)
    @Mapping(target = "healthiness", ignore = true)
    @Mapping(target = "tastiness", ignore = true)
    @Mapping(target = "id", ignore = true)
    Recipe recipeEntityToRecipe(RecipeEntity recipe);

    @Mapping(target = "name.value", source = "name")
    @Mapping(target = "description.content", source = "description")
    @Mapping(target = "preparingTime.time", source = "preparingTime")
    @Mapping(target = "recipePhoto.title", source = "recipeImagePhoto.title")
    @Mapping(target = "recipePhoto.url", source = "recipeImagePhoto.url")
    Recipe recipeRequestToRecipe(RecipeRequest recipeRequest);

    @Mapping(target = "name", source = "name.value")
    @Mapping(target = "description", source = "description.content")
    @Mapping(target = "preparingTime", source = "preparingTime.time")
    @Mapping(target = "recipeImageResponse.title", source = "recipePhoto.title")
    @Mapping(target = "recipeImageResponse.url", source = "recipePhoto.url")
    RecipeResponse recipeToRecipeResponse(Recipe savedRecipe);

    default List<Recipe> recipeEntitiesToRecipes(List<RecipeEntity> allRecipeEntities) {
        List<Recipe> mappedRecipes = new ArrayList<>();
        for (RecipeEntity recipeEntity : allRecipeEntities) {
            mappedRecipes.add(recipeEntityToRecipe(recipeEntity));
        }
        return mappedRecipes;
    }

    default List<RecipeResponse> recipesToRecipeResponses(List<Recipe> allRecipes){
        List<RecipeResponse> mappedRecipeResponses = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            mappedRecipeResponses.add(recipeToRecipeResponse(recipe));
        }
        return mappedRecipeResponses;
    }
}
