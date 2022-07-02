package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = {RecipeImageInformationEntityMapper.class})
public interface RecipeEntityMapper {

    @Mapping(target = "name", source = "name.value")
    @Mapping(target = "description", source = "description.content")
    @Mapping(target = "preparingTime", source = "preparingTime.time")
    @Mapping(target = "recipeImageInformationEntity", source = "recipeImageInformation")
    @Mapping(target = "toughness", ignore = true)
    @Mapping(target = "defaultServings", ignore = true)
    @Mapping(target = "healthiness", ignore = true)
    @Mapping(target = "tastiness", ignore = true)
    @Mapping(target = "id", ignore = true)
    RecipeEntity map(Recipe recipe);

    @Mapping(target = "name.value", source = "name")
    @Mapping(target = "description.content", source = "description")
    @Mapping(target = "preparingTime.time", source = "preparingTime")
    @Mapping(target = "recipeImageInformation", source = "recipeImageInformationEntity")
    @Mapping(target = "toughness", ignore = true)
    @Mapping(target = "healthiness", ignore = true)
    @Mapping(target = "tastiness", ignore = true)
    @Mapping(target = "id", ignore = true)
    Recipe map(RecipeEntity recipe);

    default List<Recipe> map(List<RecipeEntity> allRecipeEntities) {
        List<Recipe> mappedRecipes = new ArrayList<>();
        for (RecipeEntity recipeEntity : allRecipeEntities) {
            mappedRecipes.add(map(recipeEntity));
        }
        return mappedRecipes;
    }
}
