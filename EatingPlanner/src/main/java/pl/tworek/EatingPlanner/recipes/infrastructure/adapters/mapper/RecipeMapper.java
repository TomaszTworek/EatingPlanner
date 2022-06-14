package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.core.io.Resource;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeRequest;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response.RecipeResponse;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.ImageStorageService;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.ImageStorageServiceImpl;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RecipeMapper {

    @Mapping(target = "name", source = "name.value")
    @Mapping(target = "description", source = "description.content")
    @Mapping(target = "preparingTime", source = "preparingTime.time")
    @Mapping(target = "toughness", ignore = true)
    @Mapping(target = "defaultServings", ignore = true)
    @Mapping(target = "healthiness", ignore = true)
    @Mapping(target = "tastiness", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "recipePhotoEntity.title", source = "recipeImageInformation.imageName")
    @Mapping(target = "recipePhotoEntity.extension", source = "recipeImageInformation.extension")
    @Mapping(target = "recipePhotoEntity.size", source = "recipeImageInformation.size")
    RecipeEntity recipeToRecipeEntity(Recipe recipe);

    @Mapping(target = "name.value", source = "name")
    @Mapping(target = "description.content", source = "description")
    @Mapping(target = "preparingTime.time", source = "preparingTime")
    @Mapping(target = "toughness", ignore = true)
    @Mapping(target = "healthiness", ignore = true)
    @Mapping(target = "tastiness", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "recipeImageInformation.imageName", source = "recipePhotoEntity.title")
    @Mapping(target = "recipeImageInformation.extension", source = "recipePhotoEntity.extension")
    @Mapping(target = "recipeImageInformation.size", source = "recipePhotoEntity.size")
    Recipe recipeEntityToRecipe(RecipeEntity recipe);

    @Mapping(target = "name.value", source = "name")
    @Mapping(target = "description.content", source = "description")
    @Mapping(target = "preparingTime.time", source = "preparingTime")
    @Mapping(target = "recipeImageInformation.imageName", source = "recipeImageInformation.imageName")
    @Mapping(target = "recipeImageInformation.extension", source = "recipeImageInformation.extension")
    @Mapping(target = "recipeImageInformation.size", source = "recipeImageInformation.size")
    Recipe recipeRequestToRecipe(RecipeRequest recipeRequest);

    @Mapping(target = "name", source = "name.value")
    @Mapping(target = "description", source = "description.content")
    @Mapping(target = "preparingTime", source = "preparingTime.time")
    @Mapping(target = "resource", ignore = true)
    RecipeResponse recipeToRecipeResponse(Recipe savedRecipe);

    default List<Recipe> recipeEntitiesToRecipes(List<RecipeEntity> allRecipeEntities) {
        List<Recipe> mappedRecipes = new ArrayList<>();
        for (RecipeEntity recipeEntity : allRecipeEntities) {
            mappedRecipes.add(recipeEntityToRecipe(recipeEntity));
        }
        return mappedRecipes;
    }

    default List<RecipeResponse> recipesToRecipeResponses(List<Recipe> allRecipes) {
        List<RecipeResponse> mappedRecipeResponses = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            mappedRecipeResponses.add(recipeToRecipeResponse(recipe));
        }
        return mappedRecipeResponses;
    }
}
